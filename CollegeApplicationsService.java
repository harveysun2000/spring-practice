package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CollegeApplicationsService {
	
	@Autowired
	private CollegeApplicationsDAO collegeApplicationsDAO;
	
	@Transactional
	public List<Score> getScoresByStudentName(String studentName) {
		return collegeApplicationsDAO.getScoresByStudentName(studentName);
	}
	
}
