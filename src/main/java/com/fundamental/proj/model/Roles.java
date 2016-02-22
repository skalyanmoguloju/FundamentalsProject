package com.fundamental.proj.model;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by sai on 2/22/16.
 */
@Entity
@Table(name = "Roles")
public class Roles {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "right")
    private String right;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
