/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import com.apogee.payload.UserDto;
import java.util.List;

/**
 *
 * @author lENOVO
 */  
public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto getUserById(int userId);

    public void deleteUser(int userId);

    public List<UserDto> getAllUser();

    public UserDto updateUser(UserDto userDto, int userId);

    public boolean validateUser(String username, String password);
}
