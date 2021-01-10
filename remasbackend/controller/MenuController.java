
package com.example.remasbackend.controller;

import com.example.remasbackend.model.Menu;
import com.example.remasbackend.model.Reservation;
import com.example.remasbackend.model.Employee;
import com.example.remasbackend.repository.EmployeeRepository;
import com.example.remasbackend.repository.MenuRepository;
import com.example.remasbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class MenuController {
    
    @Autowired
    private MenuRepository menuRepository;
    
    //get all menu
    @GetMapping("/menu")
    public List<Menu> getAllMenu(){
    return menuRepository.findAll();
    }
    
    @PostMapping("/menu")
    public Menu createMenu(@RequestBody Menu admin){
    return menuRepository.save(admin);
    }
    
}
