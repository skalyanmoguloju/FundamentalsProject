package com.fundamental.proj.service;

import com.fundamental.proj.model.Items;
import com.fundamental.proj.model.Sales;
import com.fundamental.proj.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sai on 3/10/16.
 */


@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Transactional
    public void addSale(Sales sales)
    {
        salesRepository.AddSale(sales);
    }
}
