/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.payload;

/**
 *
 * @author lENOVO
 */
public class CategoryDto {

    private int categoryId;
    private String title;

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryDto() {
        super();
    }

    public CategoryDto(int categoryId, String title) {
        super();
        this.categoryId = categoryId;
        this.title = title;
    }
}
