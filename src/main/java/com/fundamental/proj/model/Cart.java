package com.fundamental.proj.model;

import javax.persistence.*;

/**
 * Created by sai on 3/14/16.
 */
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @Column(name= "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_id;

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }



    @Column(name = "user_id")
    private long user_id;

    @Column(name="quantity")
    private long quantity;

    @Column(name ="price")
    private float price;


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
