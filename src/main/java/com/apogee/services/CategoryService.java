/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.services;

import com.apogee.payload.CategoryDto;
import java.util.List;

/**
 *
 * @author lENOVO
 */
public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);

    public void deleteCategory(int categoryId);

    public CategoryDto getCategoryById(int categoryId);

    public List<CategoryDto> getAllCategory();
}
