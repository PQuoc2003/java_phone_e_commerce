package com.example.phonecommerce.service;

import com.example.phonecommerce.models.OrderItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderItemsService {

    OrderItems getOrderItemById(Long id);

    void deleteOrderItemById(Long id);

    void saveOrderItems(OrderItems orderItems);

    void updateOrderItems(OrderItems orderItems);

    List<OrderItems> getAllOrderItems();



}
