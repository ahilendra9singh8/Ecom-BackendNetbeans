package com.apogee.payload;

import java.util.HashSet;
import java.util.Set;

public class CartDto {

    private int cartId;
    private Set<CartItemDto> items = new HashSet<>();
    private UserDto user;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Set<CartItemDto> getItems() {
        return items;
    }

    public void setItems(Set<CartItemDto> items) {
        this.items = items;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}
