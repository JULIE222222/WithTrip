package com.withtrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/index")
	public String MainBoard() {
		return "index.html";
	}
	
	@GetMapping("/plan")
	public String tripplan() {
		return "tripplan";
	}

}
