/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.remasbackend.repository;

import com.example.remasbackend.Management.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ABRA
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
    
}
