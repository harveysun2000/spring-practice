package com.example.demo;

import org.springframework.web.bind.annotation.*;

import com.example.demo.types.ReviewerNameAndScore;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/")
public class CollegeApplicationsController {
	
	@Autowired
	private CollegeApplicationsService collegeApplicationsService;
	
	@GetMapping("/jdbc")
	public List<ReviewerNameAndScore> getScores(@RequestParam("studentName") String studentName /* Model model */) {
		
		// Do access control here
		// Handle empty response, if other name input
		
		System.out.println("[DEBUG] Controller received request on JDBC path.");
		List<ReviewerNameAndScore> scores = collegeApplicationsService.getScoresByStudentNameJDBC(studentName);
		return scores;
	}
	
	@GetMapping("/hibernate")
	public List<ReviewerNameAndScore> getScoresHibernate(@RequestParam("studentName") String studentName /* Model model */) {
		System.out.println("[DEBUG] Controller received request on Hibernate path.");
		List<ReviewerNameAndScore> scores = collegeApplicationsService.getScoresByStudentNameHibernate(studentName);
		return scores;
	}
}
