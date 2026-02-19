package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.types.ReviewerNameAndScore;

@Controller
@RequestMapping("/")
public class CollegeApplicationsController {
	
	@Autowired
	private CollegeApplicationsService service;
	
	@GetMapping("/getTable")
	@ResponseBody
	public Map<String, Object> getScoresTable(@RequestParam("studentName") String studentName, @RequestParam("draw") int draw) {
		List<ReviewerNameAndScore> namesAndScores = service.getScoresByStudentNameHibernate(studentName);
		// model.addAttribute("result", namesAndScores);
		
		System.out.println("[DEBUG] Controller started processing jsonResponse for DataTable");
		
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("recordsTotal", namesAndScores.size());
        jsonResponse.put("recordsFiltered", namesAndScores.size());
        jsonResponse.put("data", namesAndScores);
        jsonResponse.put("draw", draw);
        
		return jsonResponse;
	}
	
	@GetMapping("/index")
	public String getScores(Model model) {
		return "index";
	}
	
}
