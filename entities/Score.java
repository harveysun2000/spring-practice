package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Scores_t")
public class Score {
	@Id
	@Column(name = "Score_ID")
	private Integer scoreID;
	
	// JoinColumn points to the column in the One side of the mapping
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Application_ID")
	private Application application;
	
	// Specify our own column in the entity for clarity
	@Column(name = "Application_ID")
	private Integer applicationID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Reviewer_ID")
	private Reviewer reviewer;
	
	@Column(name = "Reviewer_ID")
	private Integer reviewerID;
	
	@Column(name = "Score")
	private Integer score;
	
	public Score() {
		
	}
	
	public int getScoreID() {
		return scoreID;
	}
	
	public Application getApplication() {
		return application;
	}
	
	public Integer getApplicationID() {
		return applicationID;
	}
	
	public Reviewer getReviewer() {
		return reviewer;
	}
	
	public Integer getReviewerID() {
		return reviewerID;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScoreID(Integer s) {
		scoreID = s;
	}
	
	public void setApplication(Application a) {
		application = a;
	}
	
	public void setApplicationID(Integer a) {
		applicationID = a;
	}
	
	public void setReviewer(Reviewer r) {
		reviewer = r;
	}
	
	public void setReviewerID(Integer r) {
		reviewerID = r;
	}
	
	public void setScore(Integer s) {
		score = s;
	}
	
}
