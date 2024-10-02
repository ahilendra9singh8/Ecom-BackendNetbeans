/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.services;

import com.apogee.payload.CartDto;
import com.apogee.payload.ItemRequest;

/**
 *
 * @author lENOVO
 */
public interface CartService {

    public CartDto addItem(ItemRequest item, String username);

    public CartDto getcartAll(String email);

    public CartDto getCartByID(int cartId);

    public CartDto removeCartItemFromCart(String userName, int ProductId);
}
