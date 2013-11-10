package cn.net.tongfang.framework.security.vo;

// Generated 2013-11-3 23:13:22 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;

/**
 * ExamQuerySql generated by hbm2java
 */
public class ExamQuerySql implements java.io.Serializable {

	private int id;
	private String examname;
	private String sql;
	private Serializable wherestr;
	private Serializable orderby;

	public ExamQuerySql() {
	}

	public ExamQuerySql(int id, String examname, String sql) {
		this.id = id;
		this.examname = examname;
		this.sql = sql;
	}

	public ExamQuerySql(int id, String examname, String sql,
			Serializable wherestr, Serializable orderby) {
		this.id = id;
		this.examname = examname;
		this.sql = sql;
		this.wherestr = wherestr;
		this.orderby = orderby;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamname() {
		return this.examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Serializable getWherestr() {
		return this.wherestr;
	}

	public void setWherestr(Serializable wherestr) {
		this.wherestr = wherestr;
	}

	public Serializable getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Serializable orderby) {
		this.orderby = orderby;
	}

}