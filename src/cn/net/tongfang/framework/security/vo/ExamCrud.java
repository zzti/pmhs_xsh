package cn.net.tongfang.framework.security.vo;

// Generated 2013-11-11 1:11:42 by Hibernate Tools 3.4.0.CR1

/**
 * ExamCrud generated by hbm2java
 */
public class ExamCrud implements java.io.Serializable {

	private String name;
	private String tablename;
	private String colums;
	private String pk;
	private Boolean pkeditable;
	private String pktype;

	public ExamCrud() {
	}

	public ExamCrud(String name, String tablename, String colums) {
		this.name = name;
		this.tablename = tablename;
		this.colums = colums;
	}

	public ExamCrud(String name, String tablename, String colums, String pk, Boolean pkeditable, String pktype) {
		this.name = name;
		this.tablename = tablename;
		this.colums = colums;
		this.pk = pk;
		this.pkeditable = pkeditable;
		this.pktype = pktype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getColums() {
		return this.colums;
	}

	public void setColums(String colums) {
		this.colums = colums;
	}

	public String getPk() {
		return this.pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public Boolean getPkeditable() {
		return this.pkeditable;
	}

	public void setPkeditable(Boolean pkeditable) {
		this.pkeditable = pkeditable;
	}

	public String getPktype() {
		return this.pktype;
	}

	public void setPktype(String pktype) {
		this.pktype = pktype;
	}

}