package com.company.remasbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "customer_name")
    private String customer_name;
    @Column(name = "date")
    private String date;
    @Column(name= "hour")
    private int hour;

    public Reservation() {
    }

    public Reservation(String customer_name, String date, int hour) {
        this.customer_name = customer_name;
        this.date = date;
        this.hour = hour;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
