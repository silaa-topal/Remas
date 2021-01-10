package com.example.remasbackend.controller;

import antlr.collections.List;
import com.example.remasbackend.exception.ResourceNotFoundException;
import com.example.remasbackend.model.receipt;
import com.example.remasbackend.model.order;
import com.example.remasbackend.repository.receiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Long;
import java.util.List;
import java.util.Date;
@RestController
@RequestMapping("/api/v1/")
public class receiptController {
    @Autowired
    private receiptRepository receiptRepository;

    // get all tables
    @GetMapping("/receipts")
    public List<receipt> getAllTables(){return receiptRepository.findAll();}

    @PostMapping
    public receipt createReceipt(@RequestBody receipt Receipt){
        return receiptRepository.save(Receipt);
    }

    @PostMapping
    public ResponseEntity<receipt> getReceiptByID(@PathVariable Long id){
        receipt Receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        return ResponseEntity.ok(Table);
    }

    @PostMapping("/tables")
    public void addOrderToReceipt(@PathVariable Long id, Order order){
        receipt added = receiptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        added.product.add(order);
    }

    @PostMapping
    public ResponseEntity<List<receipt>> getReceiptsBetween(Date dateOne,Date)
}
