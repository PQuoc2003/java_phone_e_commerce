package com.example.phonecommerce.controller;

import com.example.phonecommerce.dto.OrderDTO;
import com.example.phonecommerce.models.Order;
import com.example.phonecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("admin/orders")
    public String getAdminOrderPage(Model model){

        List<Order> orders = orderService.getAllOrder();

        List<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();

        for (Order order: orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.convertToDTO(order);
            orderDTOS.add(orderDTO);
        }

        model.addAttribute("orders", orderDTOS);

        return "admin_template/admin_orders";


    }

    @GetMapping("/admin/orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
        return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/edit/{id}")
    public String updateStatus(@PathVariable Long id){
        orderService.updateStatus(id);
        return "redirect:/admin/orders";
    }









}
