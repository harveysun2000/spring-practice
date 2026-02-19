package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Applications_t")
public class Application {

	@Id
	@Column(name="Application_ID")
	private Integer applicationID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Applicant_ID")
	@JsonBackReference
	private Applicant applicant;
	
	@OneToMany(mappedBy = "application")
	@JsonManagedReference
	private List<Score> scores;
	
	@Column(name="Applicant_ID", insertable=false, updatable=false)
	private int applicantID;
	
	public Application() {
		
	}
	
	public int getApplicationID() {
		return applicationID;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	// getters and setters for scores and applicantID
	
	public void setApplicationID(Integer a) {
		applicationID = a;
	}
	
	public void setApplicant(Applicant a) {
		applicant = a;
	}
}
