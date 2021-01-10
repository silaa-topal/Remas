package com.company.remasbackend.controller;

import com.company.remasbackend.model.Order;
import com.company.remasbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    // get all orders.
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    //add new order.
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
}
