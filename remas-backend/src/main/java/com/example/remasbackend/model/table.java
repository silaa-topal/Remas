package com.example.remasbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tables")
public class table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "capacity")
    private int capacity;



    public table() {
    }

    public table(long id, int capacity) {
        this.id = id;
        this.capacity = capacity;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
