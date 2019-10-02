package com.shah.lab.controller;

import com.shah.lab.dao.PatientRepository;
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
	private PatientRepository repository;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	/*@RequestMapping(value={"/dologin"}, method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestAttribute("username") long mobile,@RequestAttribute("password") String password,
								  BindingResult result, WebRequest request, Errors errors){
		ModelAndView modelAndView = new ModelAndView();
		UserDetails user=userDetailsService.findUserByMobileAndPassword(mobile,password);
		if(null!=user){
			modelAndView.addObject("user",user);
		}
		modelAndView.setViewName("homepage");
		return modelAndView;
	}*/
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDTO userDto = new UserDTO()	;
		model.addAttribute("user", userDto);
		return "registration";
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") @Valid UserDTO accountDto,
			 BindingResult result, WebRequest request, Errors errors) {
		User registered = new User();
		if (!result.hasErrors()) {
			registered = createUserAccount(accountDto, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return new ModelAndView("registration", "user", accountDto);
		}
		else {
			return new ModelAndView("successRegister", "user", accountDto);
		}
	}
	private User createUserAccount(UserDTO userDto, BindingResult result) {
		return userDetailsService.registerUser(userDto);
	}
}
