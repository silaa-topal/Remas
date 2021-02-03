package com.company.remasbackend.model;

import javax.persistence.*;
import java.util.List;
import java.util.*;
import com.company.remasbackend.model.Order;

import static java.awt.SystemColor.menu;

@Entity
@Table(name = "receipt")
public class receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    @Column(name = "orders")// will be changed
    private List<Order> orders;
    @Column(name = "dateCreated")
    private Date dateCreated = new Date() ;



    public receipt() {
    }

    public receipt(List<Order> products) {
        this.orders = orders;
    }
    
    public void addOrder(Order order){
        orders.add(order);
    }
    public Date dCreated(){
        return dateCreated;
    }
}