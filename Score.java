package com.example.demo;

public class Score {
	private String reviewerFirstName;
	private String reviewerLastName;
	private int score;
	
	public Score(String reviewerFirstName, String reviewerLastName, int score) {
		this.reviewerFirstName = reviewerFirstName;
		this.reviewerLastName = reviewerLastName;
		this.score = score;
	}
	
	// Needed by BeanPropertyRowMapper
	public Score() {
	}
	
	public String getReviewerFirstName() {
		return reviewerFirstName;
	}
	
	public void setReviewerFirstName(String fn) {
		reviewerFirstName = fn;
	}
	
	public String getReviewerLastName() {
		return reviewerLastName;
	}
	
	public void setReviewerLastName(String ln) {
		reviewerLastName = ln;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
	}
}
