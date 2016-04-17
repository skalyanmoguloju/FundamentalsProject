package com.fundamental.proj.service;

import com.fundamental.proj.model.Orders;
import com.fundamental.proj.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/25/16.
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public List<Orders> getAllOrders(long user_id)
    {
        return ordersRepository.getAllOrders(user_id);
    }
    @Transactional
    public List<Orders> getReceivedOrders(long user_id)
    {
        return ordersRepository.getReceivedOrders(user_id);
    }
    @Transactional
    public List<Long> getTotalSold(long item_id)
    {
        return ordersRepository.getTotalSold(item_id);
    }

    @Transactional
    public void udpateOrders(long order_id)
    {
        ordersRepository.udpateOrders(order_id);
    }

    @Transactional
    public List<Orders> getOrder(long order_id)
    {
        return ordersRepository.getOrderById(order_id);
    }

}
