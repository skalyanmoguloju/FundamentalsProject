package com.fundamental.proj.model;

import javax.persistence.*;

/**
 * Created by sai on 3/24/16.
 */
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "indent_id")
    private long indent_id;

    @Column(name = "item_id")
    private long item_id;

    @Column(name = "quantity")
    private long quantity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(long indent_id) {
        this.indent_id = indent_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status")
    private String status;
}
