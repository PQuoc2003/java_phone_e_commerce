package com.example.phonecommerce.service.imp;

import com.example.phonecommerce.models.Order;
import com.example.phonecommerce.repository.OrderRepository;
import com.example.phonecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateStatus(Long id) {
        Order order = orderRepository.findById(id).get();
        order.setOrder_status("Đang Giao Hàng");
        orderRepository.save(order);

    }
}
