package com.withtrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String DashBoard() {
		return "index";
	}
	
	@GetMapping("/tripplan")
	public String TripPlan() {
		
		return "tripplan";
	}

	@GetMapping("/tripdetail")
	public String TripDetail() {

		return "tripdetail";
	}

}
