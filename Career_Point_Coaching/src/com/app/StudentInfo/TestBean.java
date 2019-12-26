package com.app.StudentInfo;

public class TestBean {

	private String TName;
	private String Subject;
	private String Date;
	private int TMark;
	private int OMark;
	
	public TestBean(String TName,String Subject,String Date,int TMark,int OMark) {
		this.TName=TName;
		this.Subject=Subject;
		this.Date=Date;
		this.TMark=TMark;
		this.OMark=OMark;
	}
	
	public String getTName() {
		return TName;
	}
	public String getSubject() {
		return Subject;
	}
	public String getDate() {
		return Date;
	}
	public int getTMark() {
		return TMark;
	}
	public int getOMark() {
		return OMark;
	}
}
