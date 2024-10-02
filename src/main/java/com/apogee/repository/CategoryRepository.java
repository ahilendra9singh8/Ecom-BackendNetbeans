/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.repository;

import com.apogee.EntityModel.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lENOVO
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
