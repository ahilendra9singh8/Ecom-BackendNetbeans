/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lENOVO
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadImage(String path, MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String randomImageName = UUID.randomUUID().toString();

        String randomImageNameWithExtension = randomImageName.concat(originalFileName.substring(originalFileName.lastIndexOf(".")));
        String fullpath = path + File.separator + randomImageNameWithExtension;

        File folderFile = new File(path);

        if (!folderFile.exists()) {
            folderFile.mkdirs();
        }

        try {
            Files.copy(file.getInputStream(), Paths.get(fullpath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomImageNameWithExtension;
    }
}
