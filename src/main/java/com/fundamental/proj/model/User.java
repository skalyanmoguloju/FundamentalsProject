package com.fundamental.proj.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import java.io.Serializable;
/**
 * Created by sai on 2/18/16.
 */

@Entity
@Table(name = "User")
public class User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
