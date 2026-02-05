package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Applications_t")
public class Application {

	@Id
	@Column(name="Application_ID")
	private Integer applicationID;
	
	@ManyToOne
	@JoinColumn(name="Applicant_ID")
	private Applicant applicant;
	
	public Application() {
		
	}
	
	public int getApplicationID() {
		return applicationID;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public void setApplicationID(Integer a) {
		applicationID = a;
	}
	
	public void setApplicant(Applicant a) {
		applicant = a;
	}
}
