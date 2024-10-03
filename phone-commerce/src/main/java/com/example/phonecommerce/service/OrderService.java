package com.example.phonecommerce.service;

import com.example.phonecommerce.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> getAllOrder();

    void addOrder(Order order);

    void deleteById(Long id);

    void updateStatus(Long id);


}
