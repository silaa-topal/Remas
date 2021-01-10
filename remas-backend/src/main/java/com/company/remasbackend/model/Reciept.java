package com.company.remasbackend.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "reciepts")
public class Reciept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orders")// will be changed
    private String order;
    @Column(name = "dates_sold")
    private String date;
    @Column(name = "price")
    private double price;

    public Reciept() {
    }

    public Reciept(String order, String date, double price) {
        this.order = order;
        this.date = date;
        this.price = price;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
