package com.fundamental.proj.service;

import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Returns;
import com.fundamental.proj.repository.OrdersRepository;
import com.fundamental.proj.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sai on 4/16/16.
 */
@Service
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public String returnRequest(Returns returns)
    {
        long orders_id = returns.getOrders().getOrder_id();
        returnRepository.returnRequest(returns);
        if(returns.getOrders().getItems().getOnsale_count()-returns.getOrders().getItems().getSold_count()>0)
        {
            if(returns.getOrders().getItems().getOnsale_count()-returns.getOrders().getItems().getSold_count()>=returns.getReturn_count())
            {
                //make a new order
                Orders newOrder = returns.getOrders();
                newOrder.setOrder_id(0);
                newOrder.setQuantity(returns.getReturn_count());
                newOrder.setType("Return");
                newOrder.setRejected_quantity(0);
                newOrder.setStatus("Purchased");
                returnRepository.AddNewOrder(newOrder);
                returnRepository.updateSaleCount(newOrder.getItems().getItem_id(), (newOrder.getItems().getSold_count() + newOrder.getQuantity()));
                returns.setResolution("Replaced a new order for same product");
                returns.setOrders(ordersRepository.getOrderById(orders_id).get(0));
                returnRepository.AddReturn(returns);
                return "Full";
            }
            else
            {
                Orders newOrder = returns.getOrders();
                newOrder.setOrder_id(0);
                newOrder.setQuantity(newOrder.getItems().getOnsale_count() - newOrder.getItems().getSold_count());
                newOrder.setType("Return");
                newOrder.setRejected_quantity(0);
                newOrder.setStatus("Re-Purchased");
                returnRepository.updateSaleCount(newOrder.getItems().getItem_id(), (newOrder.getItems().getSold_count() + newOrder.getQuantity()));
                returnRepository.AddNewOrder(newOrder);
                returns.setResolution("Products are limited, placed an order with partially available products and rest will be updated when they are available");
                returns.setOrders(ordersRepository.getOrderById(orders_id).get(0));
                returnRepository.AddReturn(returns);
                return "Partial";
            }
        }
        else
        {
            returns.setResolution("Product is out of stock, will update you when they are available");
            returnRepository.AddReturn(returns);
            returns.setOrders(ordersRepository.getOrderById(orders_id).get(0));
            return "Nothing";
        }
    }
}
