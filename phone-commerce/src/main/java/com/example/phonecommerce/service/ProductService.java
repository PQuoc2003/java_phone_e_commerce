package com.example.phonecommerce.service;


import com.example.phonecommerce.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    Page<Product> getAllProduct(Pageable pageable);

    Product getProductById(Long id);

    void removeById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    List<Product> getAllProducts();



}
