package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.Product;
import com.example.phonecommerce.repository.ProductRepository;
import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
    public List<Product> getAllProduct(Pageable pageable, int page) {
        if(page > pageable.getNumberOfPages()) return null;
        Page<Product> pages = productRepository.findAll(PageRequest.of(page,5));
        return pages.getContent();
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
}
