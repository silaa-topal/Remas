/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.remasbackend.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "reservation")
public class Reservation implements Serializable{

    
        //create table reservation( tableNo int, resID int, resDate date, primary key(resID), foreign key(tableNo) references Tables(tID));
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    String name;
    @Column(name = "tableNo")
    int tableNo;
    @Column(name = "resID")
    int resID;
    @Column(name = "resDate")
    Date resDate;
    @Column(name = "resHour")
    int resHour;
    
    public Reservation() {

    }

    public Reservation(String name,int resID, int tableNo,  Date resDate,int resHour) {
        this.name=name;
        this.tableNo = tableNo;
        this.resID = resID;
        this.resDate = resDate;
        this.resHour=resHour;
    }

    public String getname(){
    return name;
    }
    
    public void setname(){
    this.name=name;
    }
    
    public int gettableNo() {
        return tableNo;
    }

    public void settableNo() {
        this.tableNo = tableNo;
    }

    public int getresID() {
        return resID;
    }

    public void setresID() {
        this.resID = resID;
    }

    public Date getresDate() {
        return resDate;
    }

    public void setresDate() {
        this.resDate = resDate;
    }
    
    public int getHour(){
    return resHour;
    }
    
    public void setHour(){
    this.resHour=resHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    



}
