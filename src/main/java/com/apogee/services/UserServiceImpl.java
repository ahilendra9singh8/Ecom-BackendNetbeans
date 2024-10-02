/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import com.apogee.EntityModel.User;
import com.apogee.Exception.ResourceNotFoundException;
import com.apogee.payload.CategoryDto;
import com.apogee.payload.UserDto;
import com.apogee.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author lENOVO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDto saveUserDto = null;
        try {
            //UserDto to User
            User user = this.mapper.map(userDto, User.class);
            //password decrypt
            String pass = user.getPassword();
            String encode = this.passwordEncoder.encode(pass);
            user.setPassword(encode);
            //save
            User saveUser = this.userRepo.save(user);
            //User to UserDto
            saveUserDto = this.mapper.map(saveUser, UserDto.class);

        } catch (Exception e) {
            System.out.println(e);
        }
        return saveUserDto;
    }

    @Override
    public UserDto getUserById(int userId) {
        User getUserById = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(+userId + "--from this userId User not found"));
        UserDto userdto = this.mapper.map(getUserById, UserDto.class);
        return userdto;
    }

    @Override
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> viewAllUser = userRepo.findAll();
        List<UserDto> findAllDto = viewAllUser.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
        return findAllDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User newUser = this.mapper.map(userDto, User.class);
        User oldUser = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(+userId + "--from this categoryId category not found"));;
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setAddress(newUser.getAddress());
        oldUser.setAbout(newUser.getAbout());
        oldUser.setPhone(newUser.getPhone());
        oldUser.setGender(newUser.getGender());
//        oldUser.setActive(newUser.getActive());

        User user = userRepo.save(oldUser);
        UserDto c = this.mapper.map(user, UserDto.class);
        return c;
    }

    @Override
    public boolean validateUser(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return true;
        } else {
            return false;
        }
//        return user != null;
        //        // Replace this with your actual user validation logic (e.g., database query)

//        return "demo".equals(email) && "password".equals(password);
    }
}
