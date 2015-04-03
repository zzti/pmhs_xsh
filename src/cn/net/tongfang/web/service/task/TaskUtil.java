package cn.net.tongfang.web.service.task;

import cn.net.tongfang.framework.security.vo.TaskRule;
import cn.net.tongfang.framework.security.vo.TaskStatus;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskUtil extends HibernateDaoSupport implements ApplicationListener {
	public static int IS_CREATED_FALSE = 0;
	public static int IS_CREATED_TRUE = 1;
	public static int IS_SENDED_FALSE = 0;
	public static int IS_SENDED_TRUE = 1;
	public static int IS_SENDED_ERROR = -1;

	private String host;
	private String name;
	private String pwd;
	private String apiId;
	private String dbName;

	private boolean started = false;
	private String processString = "";

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			createMsgJob();
		}
	}

	public void createMsgJob() {
		// TODO 启动时生成当天的任务信息 即Sms_Status 表的数据
		Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
		List isCreated = getHibernateTemplate().find("from TaskStatus where smsdate = ?", today);
		TaskStatus taskstatus = null;
		if (isCreated == null || isCreated.isEmpty()) {
			taskstatus = new TaskStatus();
			taskstatus.setSmsdate(new Timestamp(today.getTime()));
			taskstatus.setIscreated(IS_CREATED_FALSE);
			taskstatus.setIssended(IS_SENDED_FALSE);
			getHibernateTemplate().save(taskstatus);
		} else {
			taskstatus = (TaskStatus) isCreated.get(0);
		}
		// TODO 还要查看是否生成了当天应该发送的短信
		if (taskstatus.getIscreated() == IS_CREATED_FALSE) {
			taskstatus.setIscreated(IS_CREATED_TRUE);
			getHibernateTemplate().update(taskstatus);
		}
		getHibernateTemplate().flush();
		makeSendMsg();
	}

	public boolean isSended() {
		Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
		List isCreated = getHibernateTemplate().find("from TaskStatus where smsdate = ?", today);
		TaskStatus taskstatus = null;
		if (!isCreated.isEmpty()) {
			taskstatus = (TaskStatus) isCreated.get(0);
			if (taskstatus.getIssended() == IS_SENDED_TRUE) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	public void makeSendMsg() {
		// TODO 这里根据Cod_TelSendRule 表,生成Sms_SendLog表的内容 ,并且不生成重复的数据
		List<TaskRule> rules = getHibernateTemplate().find("from TaskRule ");
		Date today = new Date();
		today = DateUtils.truncate(today, Calendar.DAY_OF_MONTH);
		for (TaskRule rule : rules) {
			String tableidnamestr = "";
			if ("number".equals(rule.getIdtype())) {
				tableidnamestr = " convert(varchar,a." + rule.getTableidname() + ")";
			} else {
				tableidnamestr = "a." + rule.getTableidname();
			}
			String msg = rule.getMsg();
			msg = msg.replaceAll("\r\n", "");
			msg = msg.replaceAll("\n", "");

			final String sql;
			String datecolstr = " dateadd(day," + (rule.getDays()) + ", convert(date,a." + rule.getCol() + "))";
			if(rule.getTaskdatecol()!= null && rule.getTaskdatecol().trim().length()>0){
				datecolstr = rule.getTaskdatecol();
			}
			if ("0".equals(rule.getType())) {
				sql = " insert into Task_Log " + "select  "+ datecolstr +" ,'" + rule.getName() + "', a.fileno,c.tel,'" + msg + "'," + IS_SENDED_FALSE + " , null,null,'" + rule.getTablename() + "'," + tableidnamestr + ",null,'0',newid(), '" + rule.getId() + "', '" + rule.getParent() + "' from " + rule.getTablename() + " a , HealthFile c where  a.fileno = c.fileno and c.status = '0'" + " and NOT EXISTS (select 1 from Task_Log log where log.fileNo = a.fileNo and log.smsdate = DATEADD(D, 0, DATEDIFF(D, 0, GETDATE())) and tableidvalue = a." + rule.getTableidname() + " and examname ='" + rule.getName() + "'  ) and a." + rule.getCol() + " BETWEEN  dateadd(day," + rule.getDays() + ", convert(varchar,year( GETDATE()))+'-01-01') and dateadd(day," + rule.getDays() + ", convert(varchar,year( GETDATE())+1)+'-01-01') ";

			} else {

				sql = " insert into Task_Log " + "select  "+ datecolstr +" ,'" + rule.getName() + "', a.fileno,c.tel,'" + msg + "'," + IS_SENDED_FALSE + " , null,null,'" + rule.getTablename() + "'," + tableidnamestr + ",null,'0',newid(), '" + rule.getId() + "', '" + rule.getParent() + "' from " + rule.getTablename() + " a , HealthFile c where  a.fileno = c.fileno and c.status = '0'" + " and NOT EXISTS (select 1 from Task_Log log where log.fileNo = a.fileNo and log.smsdate = DATEADD(D, 0, DATEDIFF(D, 0, GETDATE())) and tableidvalue = a." + rule.getTableidname() + " and examname ='" + rule.getName() + "'  ) and " + rule.getRulestr();

			}
			System.out.println(sql);
			getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
					return arg0.createSQLQuery(sql).executeUpdate();
				}
			});

		}
		if (rules.size() > 0)
			getHibernateTemplate().flush();
	}

	public boolean isStarted() {
		return started;
	}

	public String getProcessString() {
		return processString;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public void setProcessString(String processString) {
		this.processString = processString;
	}

}