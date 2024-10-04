package com.example.phonecommerce.controller;

import com.example.phonecommerce.dto.OrdersDTO;
import com.example.phonecommerce.models.Orders;
import com.example.phonecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrdersService ordersService;

    @Autowired
    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("admin/orders")
    public String getAdminOrderPage(Model model){

        List<Orders> orders = ordersService.getAllOrder();

        List<OrdersDTO> ordersDTOS = new ArrayList<OrdersDTO>();

        for (Orders order: orders) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.convertToDTO(order);
            ordersDTOS.add(ordersDTO);
        }

        model.addAttribute("orders", ordersDTOS);

        return "admin_template/admin_orders";


    }

    @GetMapping("/admin/orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        ordersService.deleteById(id);
        return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/edit/{id}")
    public String updateStatus(@PathVariable Long id){
        ordersService.updateStatus(id);
        return "redirect:/admin/orders";
    }









}
