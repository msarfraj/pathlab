package com.shah.lab.controller;

import com.shah.lab.dto.UserDTO;
import com.shah.lab.model.User;
import com.shah.lab.service.impl.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController
{
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private ModelMapper modelMapper;
    @RequestMapping("/patients")
    public String viewAllPatients(WebRequest request, Model model){
        UserDTO userDto = new UserDTO()	;
        List<User> allPatients=userDetailsService.findAllPatients();
        List<UserDTO> patients=new ArrayList<>();
        for(User user:allPatients){
          UserDTO patient= modelMapper.map(user,UserDTO.class);
            patients.add(patient);
        }

        model.addAttribute("patients", patients);
        return "patient";
    }
}
