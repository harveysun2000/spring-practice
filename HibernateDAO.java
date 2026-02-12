package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.*;
import com.example.demo.types.ReviewerNameAndScore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class HibernateDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<ReviewerNameAndScore> getScoresByStudentName(String studentName) {
		
		String[] fullName = studentName.split(" ");
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ReviewerNameAndScore> cq = cb.createQuery(ReviewerNameAndScore.class);
		
		Root<Score> root = cq.from(Score.class);
		
		// Inner join relevant tables: Reviewers, Applications, Applicants
		Join<Score, Reviewer> reviewerJoin = root.join("reviewer");
		Join<Score, Application> applicationJoin = root.join("application");
		Join<Application, Applicant> applicantJoin = applicationJoin.join("applicant");
		
		// Establish the WHERE condition
		Predicate firstNamePredicate = cb.equal(applicantJoin.get("firstName"), firstName);
		Predicate lastNamePredicate = cb.equal(applicantJoin.get("lastName"), lastName);
		Predicate compoundPredicate = cb.and(firstNamePredicate, lastNamePredicate);
		
		// Define the fields to SELECT
		cq.select(cb.construct(ReviewerNameAndScore.class,
				reviewerJoin.get("firstName"),
				reviewerJoin.get("lastName"),
				root.get("score")));
		
		cq.where(compoundPredicate);
		
		// Execute the query
		TypedQuery<ReviewerNameAndScore> tq = em.createQuery(cq);
		return tq.getResultList();
	}
	
	public List<Score> getListOfScores(String studentName) {
		String[] fullName = studentName.split(" ");
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Score> cq = cb.createQuery(Score.class);
		
		Root<Score> root = cq.from(Score.class);
		
		Fetch<Score, Reviewer> reviewerFetch = root.fetch("reviewer"); 
		Join<Score, Reviewer> reviewerJoin = (Join<Score, Reviewer>) reviewerFetch;
		
		Fetch<Score, Application> applicationFetch = root.fetch("application"); 
		Join<Score, Application> applicationJoin = (Join<Score, Application>) applicationFetch;
		
		Fetch<Application, Applicant> applicantFetch = applicationFetch.fetch("applicant"); 
		Join<Application, Applicant> applicantJoin = (Join<Application, Applicant>) applicantFetch;
		
		Predicate firstNamePredicate = cb.equal(applicantJoin.get("firstName"), firstName);
		Predicate lastNamePredicate = cb.equal(applicantJoin.get("lastName"), lastName);
		Predicate compoundPredicate = cb.and(firstNamePredicate, lastNamePredicate);
		
		cq.where(compoundPredicate);
		
		TypedQuery<Score> tq = em.createQuery(cq);
		return tq.getResultList();
		
	}
}
