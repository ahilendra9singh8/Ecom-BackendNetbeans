/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.controller;

import com.apogee.payload.LoginRequest;
import com.apogee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lENOVO
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/loginpage";
    }

    @GetMapping("/loginpage")
    public String showLoginPage() {
        System.out.println("Its for testing purpose");
        return "loginpage";
    }

    @PostMapping("/login")
//    public String authenticateUser(@RequestBody LoginRequest loginRequest, Model model) {
    public String authenticateUser(@RequestParam String username, @RequestParam String password, Model model) {

        // Validate the user against the database
//        System.out.println("==========dd" + loginRequest.getUsername());
//        System.out.println("==========dd" + loginRequest.getPassword());
        System.out.println("==========" + username);
        System.out.println("==========" + password);
        boolean isValidUser = userService.validateUser(username, password);
        System.out.println("==========isValidUser  " + isValidUser);
        if (isValidUser) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginpage";
        }
    }

    @GetMapping("/dashboard")
    public String Dashboard() {
        System.out.println("Dashboard page");
        return "dashboard";
    }

    @GetMapping("/user")
    public String showUserPage() {
        return "user";
    }

    @GetMapping("/product")
    public String showProductPage() {
        return "product";
    }

    @GetMapping("/order")
    public String showOrderPage() {
        return "order";
    }

    @GetMapping("/header")
    public String HeaderTesting() {
        return "header";
    }
}
