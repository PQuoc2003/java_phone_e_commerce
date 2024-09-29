package com.example.phonecommerce.api;

import com.example.phonecommerce.models.Product;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPI {

    private final ProductService productService;


    @Autowired
    public ProductAPI(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/api/products/all")
    public Page<Product> getAllProduct(Pageable pageable){
        return productService.getAllProduct(pageable);
    }









}
