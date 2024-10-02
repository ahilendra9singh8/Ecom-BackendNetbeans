/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.config;

import com.apogee.EntityModel.User;
import com.apogee.Exception.ResourceNotFoundException;
import com.apogee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author lENOVO
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try {
            user = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
            System.out.println("user" + user);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return user;
    }

}
