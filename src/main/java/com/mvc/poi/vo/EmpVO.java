package com.mvc.poi.vo;

public class EmpVO {

	private double EMPNO,MGR, SAL, COMM, DEPTNO ;	
	private String ENAME, JOB, HIREDATE;
	
	
	public EmpVO() {
		super();
	}


	public EmpVO(double eMPNO, double mGR, double sAL, double cOMM, double dEPTNO, String eNAME, String jOB,
			String hIREDATE) {
		super();
		EMPNO = eMPNO;
		MGR = mGR;
		SAL = sAL;
		COMM = cOMM;
		DEPTNO = dEPTNO;
		ENAME = eNAME;
		JOB = jOB;
		HIREDATE = hIREDATE;
	}


	public double getEMPNO() {
		return EMPNO;
	}


	public void setEMPNO(double eMPNO) {
		EMPNO = eMPNO;
	}


	public double getMGR() {
		return MGR;
	}


	public void setMGR(double mGR) {
		MGR = mGR;
	}


	public double getSAL() {
		return SAL;
	}


	public void setSAL(double sAL) {
		SAL = sAL;
	}


	public double getCOMM() {
		return COMM;
	}


	public void setCOMM(double cOMM) {
		COMM = cOMM;
	}


	public double getDEPTNO() {
		return DEPTNO;
	}


	public void setDEPTNO(double dEPTNO) {
		DEPTNO = dEPTNO;
	}


	public String getENAME() {
		return ENAME;
	}


	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}


	public String getJOB() {
		return JOB;
	}


	public void setJOB(String jOB) {
		JOB = jOB;
	}


	public String getHIREDATE() {
		return HIREDATE;
	}


	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE;
	}

}