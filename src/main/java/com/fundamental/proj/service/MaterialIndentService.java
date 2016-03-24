package com.fundamental.proj.service;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.repository.CartRepository;
import com.fundamental.proj.repository.MaterialIndentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/24/16.
 */
@Service
public class MaterialIndentService {

    @Autowired
    private MaterialIndentRepository materialIndentRepository;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addSale(MaterialIndent materialIndent)
    {

        materialIndentRepository.AddSale(materialIndent,cartRepository.getCart(materialIndent.getUser_id()));
        cartRepository.ClearCart(materialIndent.getUser_id());
    }
}
