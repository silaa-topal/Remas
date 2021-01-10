package com.company.remasbackend.controller;

import com.company.remasbackend.model.Restaurant;
import com.company.remasbackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    // get all restaurants. (work!)
    @GetMapping("/restaurants")
    public List<Restaurant> getAllAdmins() {
        return restaurantRepository.findAll();
    }

    // add new restaurant. (work!)
    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
}
