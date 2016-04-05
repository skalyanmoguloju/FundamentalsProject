package com.fundamental.proj.controller.bean;

/**
 * Created by sai on 4/4/16.
 */
public class AddressBean {

    private long address_Id;
    private long user_id;
    private String line1;
    private String line2;
    private String city;
    private String state;
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
