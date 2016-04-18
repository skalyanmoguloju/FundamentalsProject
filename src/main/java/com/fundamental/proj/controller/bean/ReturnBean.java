package com.fundamental.proj.controller.bean;

import javax.persistence.criteria.Order;
import java.util.Date;

/**
 * Created by sai on 4/16/16.
 */
public class ReturnBean {
    private long return_id;
    private OrdersBean ordersBean;
    private String description;
    private String resolution;
    private int return_count;
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

    public String getResolution() {
        return resolution;
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

    public OrdersBean getOrdersBean() {
        return ordersBean;
    }

    public void setOrdersBean(OrdersBean ordersBean) {
        this.ordersBean = ordersBean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
