package com.example.demo.types;

public class Score {
	private int scoreID;
	private int applicationID;
	private int reviewerID;
	private int score;
	
	public Score(int sID, int aID, int rID, int s) {
		scoreID = sID;
		applicationID = aID;
		reviewerID = rID;
		score = s;
	}
	
	public Score() {
	}
	
	public int getScoreID() {
		return scoreID;
	}
	
	public void setScoreID(int sID) {
		scoreID = sID;
	}
	
	public int getApplicationID() {
		return applicationID;
	}
	
	public void setApplicationID(int aID) {
		applicationID = aID;
	}
	
	public int getReviewerID() {
		return reviewerID;
	}
	
	public void setReviewerID(int rID) {
		reviewerID = rID;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
	}
}
