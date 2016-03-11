package com.fundamental.proj.model;

import javax.persistence.*;

/**
 * Created by sai on 3/10/16.
 */

@Entity
@Table(name = "Sales")
public class Sales {


    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sale_id;


    @Column(name = "item_id")
    private long item_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "exp_date")
    private String exp_date;

    @Column(name = "card_cvv")
    private String card_cvv;

    public long getSale_id() {
        return sale_id;
    }

    public void setSale_id(long sale_id) {
        this.sale_id = sale_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }
}
