/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.controller;

import com.apogee.payload.UserDto;
import com.apogee.services.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lENOVO
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

//    http://localhost:8080/EcomBack/user/createUser
//    {
//    "name":"Raju Singh",
//    "password":"ch123",
//   "email":"cc2@gmail.com",
//   "address":"gwalior",
//    "about":"cccccc cc",
//   "gender":"Male",
//    "phone":"987654321"
//}
    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        Date date = new Date();
        userDto.setDate(date);
        UserDto createUser = this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);
    }

    //    http://localhost:8080/EcomBack/user/updateUser/11
//    {
//    "name":"Updated Raju Singh",
//    "password":"ch123",
//   "email":"cc2@gmail.com",
//   "address":"gwalior",
//    "about":"cccccc cc",
//   "gender":"Male",
//    "phone":"987654321"
//}
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.ACCEPTED);
    }
//    http://localhost:8080/EcomBack/user/getUserById/9  

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        UserDto getUserById = this.userService.getUserById(userId);
        return new ResponseEntity<UserDto>(getUserById, HttpStatus.OK);
    }

    //    http://localhost:8080/EcomBack/user/deleteUser/1
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
    }

    //    http://localhost:8080/EcomBack/user/getAllUser 
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> getAllUser = userService.getAllUser();
        return new ResponseEntity<List<UserDto>>(getAllUser, HttpStatus.ACCEPTED);
    }
}
