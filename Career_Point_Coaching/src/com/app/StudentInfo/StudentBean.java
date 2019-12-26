package com.app.StudentInfo;

public class StudentBean {
	private int REGESTRATIONID;
	private String NAME;
	private String FATHERNAME;
	private String MOTHERNAME;
	private String DOB;
	private String CLASS;
	private String MEDIUM;
	private String BATCH;
	private String SUBJECT;
	private String MOBILENO;
	private String FATHERMOBILENO;
	private String EMAILID;
	private String ADDRESS;
	

	public int getREGESTRATIONID() {
		return REGESTRATIONID;
	}


	public String getNAME() {
		return NAME;
	}


	public String getFATHERNAME() {
		return FATHERNAME;
	}


	public String getMOTHERNAME() {
		return MOTHERNAME;
	}


	public String getDOB() {
		return DOB;
	}


	public String getCLASS() {
		return CLASS;
	}


	public String getMEDIUM() {
		return MEDIUM;
	}


	public String getBATCH() {
		return BATCH;
	}


	public String getSUBJECT() {
		return SUBJECT;
	}


	public String getMOBILENO() {
		return MOBILENO;
	}


	public String getFATHERMOBILENO() {
		return FATHERMOBILENO;
	}


	public String getEMAILID() {
		return EMAILID;
	}


	public String getADDRESS() {
		return ADDRESS;
	}


	public StudentBean(int RegestrationID,String Name,String FatherName,String MotherName,String DOB,String Class,String Medium,String Batch, String Subject,String MobileNo,String FatherMobileNo,String EmailID,String Address) {
		this.REGESTRATIONID=RegestrationID;
		this.NAME=Name;
		this.ADDRESS=Address;
		this.BATCH=Batch;
		this.CLASS=Class;
		this.DOB=DOB;
		this.EMAILID=EmailID;
		this.FATHERMOBILENO=FatherMobileNo;
		this.FATHERNAME=FatherName;
		this.MEDIUM=Medium;
		this.MOBILENO=MobileNo;
		this.MOTHERNAME=MotherName;
		this.SUBJECT=Subject;
	}
	
}
