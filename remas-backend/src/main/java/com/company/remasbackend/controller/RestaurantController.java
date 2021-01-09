package com.company.remasbackend.controller;

import com.company.remasbackend.model.Restaurant;
import com.company.remasbackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/v1/")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    // get all restaurants
    @GetMapping("/restaurants")
    public List<Restaurant> getAllAdmins() {
        return restaurantRepository.findAll();
    }

}
