package com.company.remasbackend.controller;

import com.company.remasbackend.model.Reciept;
import com.company.remasbackend.repository.RecieptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class RecieptController {
    @Autowired
    private RecieptRepository recieptRepository;

    // get all receipts. (work!)
    @GetMapping("/receipts")
    public List<Reciept> getAllReciepts() {
        return recieptRepository.findAll();
    }

    // add new receipts. (work!)
    @PostMapping("/receipts")
    public Reciept addReciept(@RequestBody Reciept restaurant){
        return recieptRepository.save(restaurant);
    }
}
