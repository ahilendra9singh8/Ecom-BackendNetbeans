/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.services;

import com.apogee.EntityModel.Category;
import com.apogee.EntityModel.Product;
import com.apogee.Exception.ResourceNotFoundException;
import com.apogee.payload.CategoryDto;
import com.apogee.payload.ProductDto;
import com.apogee.payload.ProductResponse;
import com.apogee.repository.CategoryRepository;
import com.apogee.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author lENOVO
 */
@Service
public class ProductServiceIpml implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public ProductDto createProduct(ProductDto productDto, int catid) {
        //Fetch Category Available or not
        Category category = this.categoryRepo.findById(catid).orElseThrow(() -> new ResourceNotFoundException("this categoryId not found category"));;
        //productDto to product
        Product product = toEntity(productDto);
        product.setCategory(category);
        Product p = this.productRepo.save(product);
        //product to productDto
        ProductDto productdto = toProductDto(p);
        return productdto;
    }

    @Override
    public ProductResponse viewAllProduct(int pageNumber, int pageSize, String sortBy, String sortDir) {
        ProductResponse productResponse = new ProductResponse();
        try {
            Sort sort = null;
            if (sortDir.trim().toLowerCase().equals("asc")) {
                sort = Sort.by(sortBy).ascending();
                System.out.println(sort);
            } else {
                sort = Sort.by(sortBy).descending();
                System.out.println(sort);
            }

            Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

            Page<Product> page = this.productRepo.findAll(pageable);
            List<Product> pageProduct = page.getContent();
//            List<Product> product = pageProduct.stream().filter(p -> p.isLive()).collect(Collectors.toList());
            List<ProductDto> findAllDto = pageProduct.stream().map(p -> this.toProductDto(p)).collect(Collectors.toList());

            productResponse.setContent(findAllDto);
            productResponse.setPageNumber(page.getNumber());
            productResponse.setPageSize(page.getSize());
            productResponse.setTotalPage(page.getTotalPages());
            productResponse.setLastPage(page.isLast());

//        List<Product> viewAllProduct = productRepo.findAll();
//        List<ProductDto> findAllDto = viewAllProduct.stream().map(product -> this.toProductDto(product)).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("viewAllProduct" + e);
        }
        return productResponse;
    }

    @Override
    public ProductDto viewProductById(int productId) {
        Product viewProductById = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(+productId + "--from this productId product not found"));
        ProductDto productdto = toProductDto(viewProductById);
        return productdto;
    }

    @Override
    public void deleteProduct(int productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public ProductDto updateProduct(int productId, ProductDto productDto) {
        Product newProduct = toEntity(productDto);
        Product oldProduct = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(+productId + "--from this productId product not found"));;
        oldProduct.setProduct_name(newProduct.getProduct_name());
        oldProduct.setProduct_prize(newProduct.getProduct_prize());
        oldProduct.setStock(newProduct.isStock());
        oldProduct.setProduct_quantity(newProduct.getProduct_quantity());
        oldProduct.setLive(newProduct.isLive());
        oldProduct.setProduct_imageName(newProduct.getProduct_imageName());
        oldProduct.setProduct_desc(newProduct.getProduct_desc());
        Product p = productRepo.save(oldProduct);
        ProductDto updateSaveProduct = toProductDto(p);
        return updateSaveProduct;

    }

    //get product by category
    @Override
    public List<ProductDto> findProductByCategory(int categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(+categoryId + "--from this categoryId category not found"));
        List<Product> findByCategory = this.productRepo.findByCategory(category);
        List<ProductDto> collect = findByCategory.stream().map(product ->toProductDto(product)).collect(Collectors.toList());
        return collect;
    }

    //productDto to product
    public Product toEntity(ProductDto productDto) {
        Product product = new Product();

        product.setProductId(productDto.getProductId());
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_prize(productDto.getProduct_prize());
        product.setStock(productDto.isStock());
        product.setProduct_quantity(productDto.getProduct_quantity());
        product.setLive(productDto.isLive());
        product.setProduct_imageName(productDto.getProduct_imageName());
        product.setProduct_desc(productDto.getProduct_desc());

        return product;
    }

    //product to productDto
    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setProductId(product.getProductId());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setProduct_prize(product.getProduct_prize());
        productDto.setStock(product.isStock());
        productDto.setProduct_quantity(product.getProduct_quantity());
        productDto.setLive(product.isLive());
        productDto.setProduct_imageName(product.getProduct_imageName());
        productDto.setProduct_desc(product.getProduct_desc());

        //change Category to CategoryDto
        CategoryDto catDto = new CategoryDto();
        catDto.setCategoryId(product.getCategory().getCategoryId());
        catDto.setTitle(product.getCategory().getTitle());

        productDto.setCategoryDto(catDto);

        return productDto;
    }

}
