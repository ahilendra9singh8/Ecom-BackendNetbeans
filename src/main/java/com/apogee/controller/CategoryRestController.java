/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.controller;

import com.apogee.payload.CategoryDto;
import com.apogee.services.CategoryService;
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
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    CategoryService categoryservice;

//    http://localhost:8080/EcomBack/categories/createCategory
//    {
//    "title":"Mobile"
//}
    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto create = this.categoryservice.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(create, HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/EcomBack/categories/updateCategory/1
//    {
//    "title":"Mobile1"
//}
    @PutMapping("updateCategory/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategory = categoryservice.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/EcomBack/categories/getCategoryById/1
    @GetMapping("getCategoryById/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
        CategoryDto getCategoryById = categoryservice.getCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(getCategoryById, HttpStatus.OK);
    }

//    http://localhost:8080/EcomBack/categories/deleteCategory/1
    @DeleteMapping("deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        categoryservice.deleteCategory(categoryId);
        return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);
    }

//    http://localhost:8080/EcomBack/categories/getAllCategory
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> getAllCategory = categoryservice.getAllCategory();
        return new ResponseEntity<List<CategoryDto>>(getAllCategory, HttpStatus.ACCEPTED);
    }

}
