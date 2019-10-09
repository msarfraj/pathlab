package com.shah.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomePageController {
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("msg", this.message);
		return "homepage";
	}

	@RequestMapping("/welcome")
	public String welcomeNew(Map<String, Object> model) {
		model.put("msg", this.message);
		return "welcome";
	}
}
