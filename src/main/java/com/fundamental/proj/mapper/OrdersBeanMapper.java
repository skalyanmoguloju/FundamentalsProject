package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.model.Orders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/25/16.
 */
@Component
public class OrdersBeanMapper {


    public OrdersBean mapOrdersBean(Orders orders){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        MaterialIndentMapper materialIndentMapper = new MaterialIndentMapper();
        OrdersBean ordersBean = new OrdersBean();
        ordersBean.setMaterialIndentBean(materialIndentMapper.mapItemBean(orders.getMaterialIndent()));
        ordersBean.setQuantity(orders.getQuantity());
        ordersBean.setStatus(orders.getStatus());
        ordersBean.setOrder_id(orders.getOrder_id());
        ordersBean.setItemsBean(itemsBeanMapper.mapItemBean(orders.getItems()));
        return ordersBean;
    }

    public Orders mapBeanToOrders(OrdersBean ordersBean){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        MaterialIndentMapper materialIndentMapper = new MaterialIndentMapper();
        Orders orders = new Orders();
        orders.setMaterialIndent(materialIndentMapper.mapBeanToMaterialIndent(ordersBean.getMaterialIndentBean()));
        orders.setQuantity(ordersBean.getQuantity());
        orders.setStatus(ordersBean.getStatus());
        orders.setOrder_id(ordersBean.getOrder_id());
        orders.setItems(itemsBeanMapper.mapBeanToItems(ordersBean.getItemsBean()));
        return orders;
    }

    public List<OrdersBean> mapOrdersBean(List<Orders> orderss)
    {
        List<OrdersBean> ordersBeans = new ArrayList<OrdersBean>();
        for(Orders orders:orderss){
            ordersBeans.add(mapOrdersBean(orders));
        }
        return ordersBeans;
    }
}
