/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.payload;

import com.apogee.EntityModel.Product;
import java.util.List;

/**
 *
 * @author lENOVO
 */
public class ProductResponse {

    private List<ProductDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalPage;
    private boolean lastPage;

    /**
     * @return the content
     */
    public List<ProductDto> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(List<ProductDto> content) {
        this.content = content;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * @return the lastPage
     */
    public boolean getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage the lastPage to set
     */
    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
