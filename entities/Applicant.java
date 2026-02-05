package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Applicants_t")
public class Applicant {
	
	@Id
	@Column(name = "Applicant_ID")
	private Integer applicantID;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	public Applicant() {
		
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setApplicantId(Integer a) {
		applicantID = a;
	}
	
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
}
