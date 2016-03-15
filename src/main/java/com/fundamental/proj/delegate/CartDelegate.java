package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.mapper.CartBeanMapper;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/14/16.
 */
@Service
public class CartDelegate {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartBeanMapper cartBeanMapper;

    @Transactional
    public void updateCart(CartBean cartBean)
    {
        Cart cart = cartBeanMapper.mapBeanToCart(cartBean);
        cartService.updateCart(cart);
    }

    @Transactional
    public List<CartBean> getCart(long user_id)
    {
        return cartBeanMapper.mapItemsBean(cartService.getCart(user_id));
    }

}
