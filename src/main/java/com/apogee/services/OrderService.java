/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import com.apogee.payload.OrderDto;
import com.apogee.payload.OrderRequest;
import com.apogee.payload.OrderResponse;

/**
 *
 * @author lENOVO
 */
public interface OrderService {

    public OrderDto orderCreate(OrderRequest request, String username);

    public void CancelOrder(int orderId);

    public OrderDto findById(int orderId);

    public OrderResponse findAllOrders(int pageNumber, int pageSize);
}
