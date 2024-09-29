package com.example.phonecommerce.api;

import com.example.phonecommerce.models.Product;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/api/products/filter")
    public List<Product> filterProducts(
            @RequestParam(name = "productName", required = false ,defaultValue = "") String productName,
            @RequestParam(name = "color", required = false , defaultValue = "") String color,
            @RequestParam(name = "category", required = false ,defaultValue = "") String category,
            @RequestParam(name = "brand", required = false ,defaultValue = "") String brand,
            @RequestParam(name = "minPrice", required = false,defaultValue = "0")  int minPrice,
            @RequestParam(name = "maxPrice", required = false,defaultValue = "999999999") int maxPrice) {
        return productService.search(category ,productName , brand, minPrice , maxPrice ,color);
    }















}
