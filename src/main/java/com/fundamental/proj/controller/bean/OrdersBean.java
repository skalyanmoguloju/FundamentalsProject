package com.fundamental.proj.controller.bean;

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
}
