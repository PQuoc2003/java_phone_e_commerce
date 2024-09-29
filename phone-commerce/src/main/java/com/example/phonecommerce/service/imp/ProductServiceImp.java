package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.Brand;
import com.example.phonecommerce.models.Colors;
import com.example.phonecommerce.models.Product;
import com.example.phonecommerce.repository.ProductRepository;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(PageRequest.of(pageable.getPageNumber(), 5));
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> products = productRepository.findById(id);
        return products.orElse(null);
    }

    @Override
    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> search(String category, String name, String brand, int minPrice, int maxPrice, String color) {
        return productRepository.searchByManyCondition(category, name, brand, color, minPrice, maxPrice);

    }


}
