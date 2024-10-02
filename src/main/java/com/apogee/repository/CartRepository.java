package com.apogee.repository;

import com.apogee.EntityModel.Cart;
import com.apogee.EntityModel.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    public Optional<Cart> findByUser(User user);

}
