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
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status")
    private String status;


    @Column(name = "rejected_quantity")
    private long rejected_quantity;

    public long getRejected_quantity() {
        return rejected_quantity;
    }

    public void setRejected_quantity(long rejected_quantity) {
        this.rejected_quantity = rejected_quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
