package com.example.remasbackend.model;

import javax.persistence.*;
import java.util.List;
import java.util.*;
import com.example.remasbackend.model.order;

import static java.awt.SystemColor.menu;

@Entity
@Table(name = "receipt")
public class receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    @Column(name = "orders")// will be changed
    private List<order> orders;
    @Column(name = "dateCreated")
    private Date dateCreated = new Date() ;



    public receipt() {
    }

    public receipt(List<order> products) {
        this.orders = orders;
    }
    
    public void addOrder(order order){
        orders.add(order);
    }
}