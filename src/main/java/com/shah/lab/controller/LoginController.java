package com.shah.lab.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shah.lab.dao.PatientRepository;
import com.shah.lab.model.User;

@Controller
public class LoginController {
	@Autowired
	private PatientRepository repository;
	@PostMapping("/login")
	public String welcome(@RequestParam String userId
			, @RequestParam String password,Map<String, Object> model) {
		User user=repository.findUserByName(userId,password);
		if(null==user) {
		model.put("message", "user not exist");
		}else {
			model.put("message", "welcome"+user.getName());
		}
		return "welcome";
	}
}
