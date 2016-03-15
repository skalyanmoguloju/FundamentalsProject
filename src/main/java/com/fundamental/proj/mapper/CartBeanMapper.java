package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.model.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/14/16.
 */
@Component
public class CartBeanMapper {



    public CartBean mapItemBean(Cart cart){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        CartBean cartBean = new CartBean();
        cartBean.setPrice(cart.getPrice());
        cartBean.setQuantity(cart.getQuantity());
        cartBean.setUser_id(cart.getUser_id());
        cartBean.setCart_id(cart.getCart_id());
        cartBean.setItemsBean(itemsBeanMapper.mapItemBean(cart.getItems()));
        return cartBean;
    }

    public Cart mapBeanToCart(CartBean cartBean){
        Cart cart = new Cart();
        cart.setPrice(cartBean.getPrice());
        cart.setQuantity(cartBean.getQuantity());
        cart.setUser_id(cartBean.getUser_id());
        cart.setCart_id(cartBean.getCart_id());
        return cart;
    }

    public List<CartBean> mapItemsBean(List<Cart> carts)
    {
        List<CartBean> cartBeans = new ArrayList<CartBean>();
        for(Cart cart:carts){
            cartBeans.add((mapItemBean(cart)));
        }
        return cartBeans;
    }
}
