package com.shah.lab.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shah.lab.dao.SystemRepository;
import com.shah.lab.model.UserModel;

@Controller
public class LoginController {
	@Autowired
	private SystemRepository repository;
	@GetMapping("/login")
	public String welcome(@RequestParam String userId
			, @RequestParam String password,Map<String, Object> model) {
		Optional<UserModel> user=repository.findById(userId);
		if(user.isPresent()) {
		if(user.get().getPassword()==password) {
			model.put("message", "Welcome to lab!!");
		}else {
			model.put("message", "Incorrect password");
		}
		}else {
		model.put("message", "user not exist");
		}
		return "welcome";
	}
}
