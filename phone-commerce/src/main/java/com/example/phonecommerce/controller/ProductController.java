package com.example.phonecommerce.controller;


import com.example.phonecommerce.service.BrandService;
import com.example.phonecommerce.service.CategoryService;
import com.example.phonecommerce.service.ColorsService;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductService productService;
    private final ColorsService colorsService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    @Autowired

    public ProductController(ProductService productService, ColorsService colorsService, BrandService brandService, CategoryService categoryService) {
        this.productService = productService;
        this.colorsService = colorsService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }
}
