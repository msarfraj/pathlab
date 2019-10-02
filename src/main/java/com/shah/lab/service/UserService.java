package com.shah.lab.service;

import com.shah.lab.dto.UserDTO;
import com.shah.lab.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService
{
    User registerUser(UserDTO userDTO);
   // UserDetails findUserByMobileAndPassword(long mobile, String Password);
}
