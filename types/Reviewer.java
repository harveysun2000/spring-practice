package com.example.demo.types;

public class Reviewer {
	private int reviewerID;
	private String firstName;
	private String lastName;
	
	public Reviewer(int r, String f, String l) {
		reviewerID = r;
		firstName = f;
		lastName = l;
	}
	
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
	
	public void setReviewerID(int r) {
		reviewerID = r;
	}
	
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
}
