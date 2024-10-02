/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.EntityModel;

import com.apogee.payload.CategoryDto;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lENOVO
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String product_name;
    private double product_prize;
    private boolean stock;
    private int product_quantity;
    private boolean live;
    private String product_imageName;
    private String product_desc;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

//    @OneToOne
//    private CartItem cartItem;
    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the product_prize
     */
    public double getProduct_prize() {
        return product_prize;
    }

    /**
     * @param product_prize the product_prize to set
     */
    public void setProduct_prize(double product_prize) {
        this.product_prize = product_prize;
    }

    /**
     * @return the stock
     */
    public boolean isStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(boolean stock) {
        this.stock = stock;
    }

    /**
     * @return the product_quantity
     */
    public int getProduct_quantity() {
        return product_quantity;
    }

    /**
     * @param product_quantity the product_quantity to set
     */
    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    /**
     * @return the live
     */
    public boolean isLive() {
        return live;
    }

    /**
     * @param live the live to set
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * @return the product_imageName
     */
    public String getProduct_imageName() {
        return product_imageName;
    }

    /**
     * @param product_imageName the product_imageName to set
     */
    public void setProduct_imageName(String product_imageName) {
        this.product_imageName = product_imageName;
    }

    /**
     * @return the product_desc
     */
    public String getProduct_desc() {
        return product_desc;
    }

    /**
     * @param product_desc the product_desc to set
     */
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
