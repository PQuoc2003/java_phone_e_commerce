package com.example.phonecommerce.service;

import com.example.phonecommerce.models.CartItems;

import java.util.List;
import java.util.Optional;

public interface CartItemsService {

    CartItems getCartItemById(Long id);

    boolean deleteCartItemById(Long id);

    void save(CartItems cartItems);

    List<CartItems> getCartItemByCartId(Long id);


}
