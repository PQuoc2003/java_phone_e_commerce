package com.example.phonecommerce.controller;


import com.example.phonecommerce.models.Brand;
import com.example.phonecommerce.models.Category;
import com.example.phonecommerce.models.Colors;
import com.example.phonecommerce.models.Product;
import com.example.phonecommerce.service.BrandService;
import com.example.phonecommerce.service.CategoryService;
import com.example.phonecommerce.service.ColorsService;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping(value = "/admin/product")
    public String productAdminPage(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "admin_template/admin_product";
    }

    @GetMapping(value = {"/admin/product/add"})
    public String addProductPage(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        List<Brand> brands = brandService.getAllBrand();
        List<Colors> colors = colorsService.getAllColor();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        model.addAttribute("colors", colors);
        return "admin_template/admin_add-products";
    }

    @PostMapping( value = {"/admin/product/add"})
    public String addProduct(@ModelAttribute("product") Product product , @ModelAttribute("image") String image) {
        product.setPicture(image);
        productService.addProduct(product);

        return "redirect:/admin/product";
    }









}
