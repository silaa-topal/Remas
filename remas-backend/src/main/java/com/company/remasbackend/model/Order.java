package com.company.remasbackend.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_name")
    private String order_name;
    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(String order_name, String status) {
        this.order_name = order_name;
        this.status = status;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
