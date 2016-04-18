package com.fundamental.proj.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sai on 4/16/16.
 */
@Entity
@Table(name = "returns")
public class Returns {
    @Id
    @Column(name= "return_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long return_id;



    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Column(name = "resolution")
    private  String resolution;

    public String getResolution() {
        return resolution;
    }

    @Column(name ="return_count")
    private int return_count;

    @Column(name ="return_date")
    private Date return_date;

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public int getReturn_count() {
        return return_count;
    }

    public void setReturn_count(int return_count) {
        this.return_count = return_count;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getReturn_id() {
        return return_id;
    }

    public void setReturn_id(long return_id) {
        this.return_id = return_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
