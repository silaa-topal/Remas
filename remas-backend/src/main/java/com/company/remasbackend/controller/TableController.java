package com.company.remasbackend.controller;

import com.company.remasbackend.model.Table;
import com.company.remasbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class TableController {
    @Autowired
    private TableRepository tableRepository;

    // get all tables. (works!)
    @GetMapping("/tables")
    public List<Table> getAllTables(){
        return tableRepository.findAll();
    }

    //add new tables. (works!)
    @PostMapping("/table")
    public Table addTable(@RequestBody Table table){
        return tableRepository.save(table);
    }
}