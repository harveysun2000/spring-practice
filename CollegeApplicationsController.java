package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class CollegeApplicationsController {
	
	@Autowired
	private CollegeApplicationsService collegeApplicationsService;
	
	@GetMapping("/checkApplications")
	public List<Score> getScores(@RequestParam("studentName") String studentName /* Model model */) {
		System.out.println("[DEBUG] HTTP Request received by CollegeApplicationsController.");
		List<Score> scores = collegeApplicationsService.getScoresByStudentName(studentName);
		return scores;
	}
}
