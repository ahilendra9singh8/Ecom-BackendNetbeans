/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.repository;

import com.apogee.EntityModel.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lENOVO
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User>findByEmail(String email); 
    User findByEmailAndPassword(String email, String password);
}
