package com.company.remasbackend.controller;

import com.company.remasbackend.model.Admin;
import com.company.remasbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/v1/")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    // get all admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
}
