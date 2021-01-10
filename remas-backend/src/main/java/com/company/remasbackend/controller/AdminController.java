package com.company.remasbackend.controller;

import com.company.remasbackend.model.Admin;
import com.company.remasbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    // get all admins. (works!)
    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    //add new admin. (works!)
    @PostMapping("/admins")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }
}
