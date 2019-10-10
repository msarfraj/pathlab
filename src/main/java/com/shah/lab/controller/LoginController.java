package com.shah.lab.controller;

import com.shah.lab.dto.UserDTO;
import com.shah.lab.model.User;
import com.shah.lab.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login(){
		return "login";
	}


	@RequestMapping(value = "/register/admin", method = RequestMethod.GET)
	public String showPatientForm(WebRequest request, Model model) {
		UserDTO userDto = new UserDTO()	;
		model.addAttribute("user", userDto);
		return "registerAdmin";
	}
	@RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") @Valid UserDTO data,
			 BindingResult result, WebRequest request, Errors errors) {
		User registered = new User();
		if (!result.hasErrors()) {
			registered = userDetailsService.registerUser(data);
		}
		if (registered == null) {
			return new ModelAndView("homepage", "msg", String.format("%s already Exist",data.getName()));
		}
		if (result.hasErrors()) {
			return new ModelAndView("homepage", "msg", String.format("Error in form data !! Try again"));
		}
		else {
			return new ModelAndView("homepage", "msg", String.format("Successfully registered- %s",data.getName()));
		}
	}


}
