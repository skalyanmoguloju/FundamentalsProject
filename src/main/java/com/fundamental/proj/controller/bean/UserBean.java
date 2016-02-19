package com.fundamental.proj.controller.bean;

import java.io.Serializable;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
