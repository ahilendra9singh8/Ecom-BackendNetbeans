/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.services;

import com.apogee.EntityModel.Product;
import com.apogee.payload.ProductDto;
import com.apogee.payload.ProductResponse;
import java.util.List;

/**
 *
 * @author lENOVO
 */
public interface ProductService {

    public ProductDto createProduct(ProductDto productDto, int catid);

    public ProductResponse viewAllProduct(int pageNumber, int pageSize, String sortBy, String sortDir);

    public ProductDto viewProductById(int productId);

    public void deleteProduct(int productId);

    public ProductDto updateProduct(int productId, ProductDto newProduct);

    public List<ProductDto> findProductByCategory(int categoryId);

}
