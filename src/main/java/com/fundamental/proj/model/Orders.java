package com.fundamental.proj.model;

import javax.persistence.*;

/**
 * Created by sai on 3/24/16.
 */
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long order_id;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    @ManyToOne
    @JoinColumn(name = "indent_id")
    private MaterialIndent materialIndent;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;


    @Column(name = "quantity")
    private long quantity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MaterialIndent getMaterialIndent() {
        return materialIndent;
    }

    public void setMaterialIndent(MaterialIndent materialIndent) {
        this.materialIndent = materialIndent;
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
