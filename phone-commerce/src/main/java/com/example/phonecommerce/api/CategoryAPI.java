package com.example.phonecommerce.api;

import com.example.phonecommerce.models.Category;
import com.example.phonecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryAPI {

    private final CategoryService categoryService;

    @Autowired
    public CategoryAPI(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/api/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }
}
