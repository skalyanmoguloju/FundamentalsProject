package com.fundamental.proj.controller.bean;

import java.util.Date;

/**
 * Created by sai on 3/25/16.
 */
public class OrdersBean {

    private long order_id;
    private MaterialIndentBean materialIndentBean;
    private int quantity;
    private String status;

    public ItemsBean getItemsBean() {
        return itemsBean;
    }

    public void setItemsBean(ItemsBean itemsBean) {
        this.itemsBean = itemsBean;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public MaterialIndentBean getMaterialIndentBean() {
        return materialIndentBean;
    }

    public void setMaterialIndentBean(MaterialIndentBean materialIndentBean) {
        this.materialIndentBean = materialIndentBean;
    }

    private int rejected_quantity;

    private Date purchase_date;

    private Date delivery_date;

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getRejected_quantity() {
        return rejected_quantity;
    }

    public void setRejected_quantity(int rejected_quantity) {
        this.rejected_quantity = rejected_quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private ItemsBean itemsBean;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
