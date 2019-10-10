package com.shah.lab.service.impl;

import com.shah.lab.dao.ReferrerRepository;
import com.shah.lab.dao.RoleRepository;
import com.shah.lab.dao.UserRepository;
import com.shah.lab.dto.UserDTO;
import com.shah.lab.enums.UserType;
import com.shah.lab.model.Role;
import com.shah.lab.model.User;
import com.shah.lab.service.UserService;
import com.shah.lab.util.PathLabUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User registerUser(UserDTO userDTO)
    {
        if (null != userRepository.findByMobile(Long.parseLong(userDTO.getMobile())))
        {
            return null;
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setMobile(Long.parseLong(userDTO.getMobile()));
        user.setEmail(userDTO.getEmail());
        Role userRole = roleRepository.findByName(userDTO.getRole());
        if (null == userRole)
        {
            Role role = new Role();
            role.setName(userDTO.getRole());
            userRole = roleRepository.save(role);
        }
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        if(userDTO.getRole().equals("PATIENT")){
            user.setPassword(bCryptPasswordEncoder.encode(PathLabUtil.createCustomPassword(userDTO.getName(), userDTO.getMobile())));
            addPatientDetails(user,userDTO);
        }else {
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        return userRepository.save(user);

    }

    @Override
    public List<User> findAllPatients()
    {
        Role role=roleRepository.findByName(UserType.PATIENT.toString());
        if(null==role){
            return Collections.EMPTY_LIST;
        }
        return userRepository.findAllByRolesIsContaining(role);
    }


    private void addPatientDetails(User user,UserDTO userDTO)
    {
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setReferredBy(userDTO.getReferredBy());
        user.setEmail(userDTO.getEmail());
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userRepository.findByMobile(Long.parseLong(s));

        if (null != user)
        {
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), createAuthorityList(user));
        } else
        {
            throw new UsernameNotFoundException("Invalid Username");
        }
    }

    private List<GrantedAuthority> createAuthorityList(User user)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

}

