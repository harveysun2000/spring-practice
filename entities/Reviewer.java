package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reviewers_t")
public class Reviewer {

	@Id
	@Column(name = "Reviewer_ID")
	private Integer reviewerID;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@OneToMany(mappedBy = "reviewer")
	private List<Score> scores;
	
	public Reviewer() {
		
	}
	
	public int getReviewerID() {
		return reviewerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	public void setReviewerID(Integer r) {
		reviewerID = r;
	}
	
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
	
	public void setScores(List<Score> s) {
		scores = s;
	}
}
