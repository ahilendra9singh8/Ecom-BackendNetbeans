/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.payload;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lENOVO
 */
@Getter
@Setter
public class UserDto {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String about;
    private String gender;
    private String phone;
    private Date date;
    private boolean active;  
}
