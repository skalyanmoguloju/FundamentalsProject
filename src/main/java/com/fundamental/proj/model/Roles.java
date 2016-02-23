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
    @Column(name = "role")
    private String role;

    @Column(name = "right")
    private String rights;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}
