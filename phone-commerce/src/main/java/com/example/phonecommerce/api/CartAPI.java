package com.example.phonecommerce.api;

import com.example.phonecommerce.service.CartItemsService;
import com.example.phonecommerce.service.ProductService;
import com.example.phonecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartAPI {


    private final CartItemsService cartItemsService;

    private final UserService userService;

    private final ProductService productService;

    @Autowired
    public CartAPI(CartItemsService cartItemsService, UserService userService, ProductService productService) {
        this.cartItemsService = cartItemsService;
        this.userService = userService;
        this.productService = productService;
    }


}
