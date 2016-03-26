package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.mapper.OrdersBeanMapper;
import com.fundamental.proj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/25/16.
 */
@Service
public class OrdersDelegate {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersBeanMapper ordersBeanMapper;

    @Transactional
    public List<OrdersBean> getAllOrderss(long user_id)
    {
        return ordersBeanMapper.mapOrdersBean(ordersService.getAllOrders(user_id));
    }

}