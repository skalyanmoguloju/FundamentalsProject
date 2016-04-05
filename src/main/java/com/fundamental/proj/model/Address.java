package com.fundamental.proj.model;

import javax.persistence.*;

/**
 * Created by sai on 4/4/16.
 */
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Column(name= "address_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long address_Id;

    @Column(name = "user_id")
    private long user_id;
    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private long zip;

    public long getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(long address_Id) {
        this.address_Id = address_Id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }
}
