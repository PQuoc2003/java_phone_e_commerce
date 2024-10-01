package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.CartItems;
import com.example.phonecommerce.service.CartItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsImp implements CartItemsService {
    @Override
    public CartItems getCartItemById(Long id) {
        return null;
    }

    @Override
    public boolean deleteCartItemById(Long id) {
        return false;
    }

    @Override
    public void save(CartItems cartItems) {

    }

    @Override
    public List<CartItems> getCartItemByCartId(Long id) {
        return null;
    }
}
