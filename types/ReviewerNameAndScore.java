package com.example.demo.types;

public class ReviewerNameAndScore {
	private String reviewerFirstName;
	private String reviewerLastName;
	private int score;
	
	public ReviewerNameAndScore(String reviewerFirstName, String reviewerLastName, int score) {
		this.reviewerFirstName = reviewerFirstName;
		this.reviewerLastName = reviewerLastName;
		this.score = score;
	}
	
	// Needed by BeanPropertyRowMapper
	public ReviewerNameAndScore() {
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
