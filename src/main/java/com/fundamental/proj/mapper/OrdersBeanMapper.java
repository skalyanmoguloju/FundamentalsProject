package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.model.Address;
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
        AddressBeanMapper addressBeanMapper = new AddressBeanMapper();
        ordersBean.setMaterialIndentBean(materialIndentMapper.mapItemBean(orders.getMaterialIndent()));
        ordersBean.setQuantity(orders.getQuantity());
        ordersBean.setStatus(orders.getStatus());
        ordersBean.setOrder_id(orders.getOrder_id());
        ordersBean.setRejected_quantity(orders.getRejected_quantity());
        ordersBean.setItemsBean(itemsBeanMapper.mapItemBean(orders.getItems()));
        ordersBean.setAddressBean(addressBeanMapper.mapAddressBean(orders.getAddress()));
        return ordersBean;
    }

    public Orders mapBeanToOrders(OrdersBean ordersBean){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        MaterialIndentMapper materialIndentMapper = new MaterialIndentMapper();
        Orders orders = new Orders();
        AddressBeanMapper addressBeanMapper = new AddressBeanMapper();
        orders.setMaterialIndent(materialIndentMapper.mapBeanToMaterialIndent(ordersBean.getMaterialIndentBean()));
        orders.setQuantity(ordersBean.getQuantity());
        orders.setStatus(ordersBean.getStatus());
        orders.setOrder_id(ordersBean.getOrder_id());
        orders.setRejected_quantity((ordersBean.getRejected_quantity()));
        orders.setItems(itemsBeanMapper.mapBeanToItems(ordersBean.getItemsBean()));
        orders.setAddress(addressBeanMapper.mapBeanToAddress(ordersBean.getAddressBean()));
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
