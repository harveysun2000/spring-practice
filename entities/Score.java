package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@ManyToOne
	@JoinColumn(name = "Application_ID")
	private Application application;
	
	@ManyToOne
	@JoinColumn(name = "Reviewer_ID")
	private Reviewer reviewer;
	
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
	
	public Reviewer getReviewer() {
		return reviewer;
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
	
	public void setReviewer(Reviewer r) {
		reviewer = r;
	}
	
	public void setScore(Integer s) {
		score = s;
	}
	
}
