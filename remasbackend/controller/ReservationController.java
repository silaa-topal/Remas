package com.example.remasbackend.controller;


import com.example.remasbackend.model.Reservation;
import com.example.remasbackend.model.Employee;
import com.example.remasbackend.repository.EmployeeRepository;
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
public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    //get all reservation
    @GetMapping("/reservations")
    public List<Reservation> getAllReservation(){
    return reservationRepository.findAll();
    }
    
    
    @PostMapping("/reservations")
    public Reservation createReservation(@RequestBody Reservation admin){
    return reservationRepository.save(admin);
    }
    
    
}
