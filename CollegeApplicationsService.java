package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.types.ReviewerNameAndScore;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CollegeApplicationsService {
	
	@Autowired
	private JdbcDAO jdbcDAO;
	
	@Autowired
	private HibernateDAO hibernateDAO;
	
	@Transactional
	public List<ReviewerNameAndScore> getScoresByStudentNameJDBC(String studentName) {
		return jdbcDAO.getScoresByStudentName(studentName);
	}
	
	@Transactional
	public List<ReviewerNameAndScore> getScoresByStudentNameHibernate(String studentName) {
		return hibernateDAO.getScoresByStudentName(studentName);
	}
	
}
