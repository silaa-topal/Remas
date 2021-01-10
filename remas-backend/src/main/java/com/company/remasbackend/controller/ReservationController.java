package com.company.remasbackend.controller;

import com.company.remasbackend.model.Reservation;
import com.company.remasbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    // get all reservations .(works)
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    //add new reservation. (works!)
    @PostMapping("/reservations")
    public Reservation addReservations(@RequestBody Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
