package com.shah.lab.service;

import com.shah.lab.dto.UserDTO;
import com.shah.lab.model.User;

import java.util.List;

public interface UserService
{
    User registerUser(UserDTO userDTO);

    List<User> findAllPatients();

}
