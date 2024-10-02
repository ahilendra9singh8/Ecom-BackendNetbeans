/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.payload;

import java.util.List;

/**
 *
 * @author lENOVO
 */
public class OrderResponse {

    private int pageSize;
    private int pageNumber;
    private int totalPage;
    private Long totalElemet;
    private List<OrderDto> content;
    private boolean isLastPage;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalElemet() {
        return totalElemet;
    }

    public void setTotalElemet(Long totalElemet) {
        this.totalElemet = totalElemet;
    }

    public List<OrderDto> getContent() {
        return content;
    }

    public void setContent(List<OrderDto> content) {
        this.content = content;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

}
