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

    private long rejected_quantity;

    private AddressBean addressBean;

    public long getRejected_quantity() {
        return rejected_quantity;
    }

    public void setRejected_quantity(long rejected_quantity) {
        this.rejected_quantity = rejected_quantity;
    }

    public AddressBean getAddressBean() {
        return addressBean;
    }

    public void setAddressBean(AddressBean addressBean) {
        this.addressBean = addressBean;
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
