package com.company.remasbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "work_place")
    private String work_place;
    @Column(name = "job")
    private String job;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public Employee() {
    }

    public Employee(String full_name, String work_place, String job) {
        this.full_name = full_name;
        this.work_place = work_place;
        this.job = job;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
