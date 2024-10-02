/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.repository;

import com.apogee.EntityModel.Category;
import com.apogee.EntityModel.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lENOVO
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    public Product findById(int product);
    Page<Product> findAll(Pageable pageable);

    public List<Product> findByCategory(Category category);
}
