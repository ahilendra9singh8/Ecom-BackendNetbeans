/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lENOVO
 */
public interface FileUploadService {

    public String uploadImage(String path, MultipartFile file);
}
