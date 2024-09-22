package com.example.phonecommerce.service;


import com.example.phonecommerce.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface ProductService {


    List<Product> getAllProduct(Pageable pageable, int page);

    Product getProductById(Long id);

    void removeById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    List<Product> getAllProducts();



}
