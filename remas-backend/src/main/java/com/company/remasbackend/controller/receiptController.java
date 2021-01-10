package com.example.remasbackend.controller;


import com.example.remasbackend.exception.ResourceNotFoundException;
import com.example.remasbackend.model.receipt;
import com.example.remasbackend.model.order;
import com.example.remasbackend.model.table;
import com.example.remasbackend.repository.receiptRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Date;
@RestController
@RequestMapping("/api/v1/")
public class receiptController {
    @Autowired
    private receiptRepository receiptRepository;

    // get all tables
    @GetMapping("/receipts")
    public List<order> getAllTables(){
        return receiptRepository.findAll();}

    @PostMapping
    public receipt createReceipt(@RequestBody receipt Receipt){
        return receiptRepository.save(Receipt);
    }

    @PostMapping
    public ResponseEntity<receipt> getReceiptByID(@PathVariable Long id){
        receipt Receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        return ResponseEntity.ok(Receipt);
    }

    @PostMapping("/tables")
    public void addOrderToReceipt(@PathVariable Long id, order order){
        receipt added = receiptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        added.addOrder(order);
    }

//    @PostMapping
//    public ResponseEntity<List<receipt>> getReceiptsBetween(Date dateOne,Date)
}
