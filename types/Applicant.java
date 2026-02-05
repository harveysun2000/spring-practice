package com.example.demo.types;

public class Applicant {
	private int applicantID;
	private String firstName;
	private String lastName;
	
	public Applicant(int aID, String f, String l) {
		applicantID = aID;
		firstName = f;
		lastName = l;
	}
	
	public Applicant() {
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public void setApplicantID(int a) {
		applicantID = a;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
}
