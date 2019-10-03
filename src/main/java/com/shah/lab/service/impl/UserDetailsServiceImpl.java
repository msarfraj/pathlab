package com.shah.lab.service.impl;

import com.shah.lab.dao.PatientRepository;
import com.shah.lab.dao.RoleRepository;
import com.shah.lab.dto.UserDTO;
import com.shah.lab.model.Role;
import com.shah.lab.model.User;
import com.shah.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(UserDTO userDTO)
    {
        if (emailExists(userDTO.getMobile()))
        {
            return null;
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setMobile(Long.parseLong(userDTO.getMobile()));
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setReferredBy(userDTO.getReferredBy());
        user.setEmail(userDTO.getEmail());
        Role userRole = roleRepository.findByName(userDTO.getName());
        if (null == userRole)
        {
            Role role = new Role();
            role.setName(userDTO.getRole());
            userRole = roleRepository.save(role);
        }
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        return patientRepository.save(user);
    }

    private boolean emailExists(String mobile)
    {
        User user = patientRepository.findByMobile(Long.parseLong(mobile));
        if (user != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = patientRepository.findByMobile(Long.parseLong(s));

        if (null != user)
        {
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),createAuthorityList(user));
        } else
        {
            throw new UsernameNotFoundException("Invalid Username");
        }
    }

    private List<GrantedAuthority> createAuthorityList(User user)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
         for (Role role : user.getRoles()){
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
         }
        return grantedAuthorities;
    }

}

