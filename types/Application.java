package com.example.demo.types;

public class Application {
	private int applicationID;
	private int applicantID;
	// would use java.time package for application date
	
	public Application(int applicationID, int applicantID) {
		this.applicationID = applicationID;
		this.applicantID = applicantID;
	}
	
	public Application() {
		
	}
	
	public int getApplicationID() {
		return applicationID;
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public void setApplicationID(int a) {
		applicationID = a;
	}
	
	public void setApplicantID(int a) {
		applicantID = a;
	}
}
