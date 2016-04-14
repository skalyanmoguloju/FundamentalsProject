package com.fundamental.proj.service;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/14/16.
 */
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void updateCart(Cart cart)
    {
        cartRepository.updateCart(cart);
    }

    @Transactional
    public List<Cart> getCart(long user_id)
    {
        return cartRepository.getCart(user_id);
    }

    @Transactional
    public void AddToCart(Cart cart, int flag)
    {
        cartRepository.AddToCart(cart, flag);
    }

    @Transactional
    public void clearCart(long user_id)
    {
        cartRepository.ClearCart(user_id);
    }
}
