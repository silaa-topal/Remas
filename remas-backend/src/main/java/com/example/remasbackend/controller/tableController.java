package com.example.remasbackend.controller;


import com.example.remasbackend.exception.ResourceNotFoundException;
import com.example.remasbackend.model.table;
import com.example.remasbackend.repository.tableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/v1/")
public class tableController {
    @Autowired
    private tableRepository TableRepository;

    // get all tables
    @GetMapping("/tables")
    public List<table> getAllTables(){return TableRepository.findAll();}

    @PostMapping
    public table createTable(@RequestBody table Table){
        return TableRepository.save(Table);
    }

    @PostMapping
    public ResponseEntity<table> getTableByID(@PathVariable Long id){
        table Table = TableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not exist with id : "+id));
        return ResponseEntity.ok(Table);
    }

    @PatchMapping("/tables")
    public void changeCapacity(@PathVariable Long id, int capacity){
        table changed = TableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Table not exist with id : "+id));
        changed.setCapacity(capacity);
    }
}
