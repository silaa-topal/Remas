package com.company.remasbackend.controller;

import com.company.remasbackend.model.Menu;
import com.company.remasbackend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    // get all admins. (works!)
    @GetMapping("/menu")
    public List<Menu> getTheMenu(){
        return menuRepository.findAll();
    }

    //add new admin. (works!)
    @PostMapping("/menu")
    public Menu addMenuItem(@RequestBody Menu menu){
        return menuRepository.save(menu);
    }
}
