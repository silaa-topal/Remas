package com.company.remasbackend.controller;

import com.company.remasbackend.model.Order;
import com.company.remasbackend.repository.OrderRepository;
import com.example.remasbackend.exception.ResourceNotFoundException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

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
    
    @GetMapping("/chef/orders")
    public List<Order> getAllCOrders(){
        List<Order> list=orderRepository.findAll();
        List<Order> ret = null;
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getStatus()!="Ready to deliver"||list.get(i).getStatus()!=""){
                ret.add(list.get(i));
            }
        }
        return ret;
    }

    //add new order.
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
    @PatchMapping("/chef/orders")
    public ResponseEntity<Order> updateCOrder(@PathVariable Long id){
        Order curr = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id "+id+" couldn't found"));
        curr.setStatus("Ready to deliver");
        return ResponseEntity.ok(curr);
    }
}
