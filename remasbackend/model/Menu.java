/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.remasbackend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ABRA
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "item_name")
    String item_name;
    @Column(name = "price")
    int price;
    
    public Menu(){
    
    }
    
    public Menu(String name, int price){
    this.item_name=item_name;
    this.price=price;
    }
    
    public String getName(){
    return item_name;
    }
    
    public void setName(String name){
    this.item_name=item_name;
    }
    
    public int getPrice(){
    return price;
    }
    
    public void setPrice(int price){
    this.price = price;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
