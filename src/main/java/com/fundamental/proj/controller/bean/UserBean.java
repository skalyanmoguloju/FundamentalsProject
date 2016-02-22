package com.fundamental.proj.controller.bean;

import java.util.Date;

/**
 * Created by sai on 2/18/16.
 */
public class UserBean {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {

        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String lname;
    private Date dob;
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
