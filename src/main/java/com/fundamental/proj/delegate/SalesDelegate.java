package com.fundamental.proj.delegate;
import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.mapper.SalesBeanMapper;
import com.fundamental.proj.model.Sales;
import com.fundamental.proj.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sai on 3/10/16.
 */
@Service
public class SalesDelegate {


    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesBeanMapper salesBeanMapper;

    @Transactional
    public void addSale(SalesBean salesBean)
    {
        Sales sales;
        sales = salesBeanMapper.mapBeanToSales(salesBean);
        salesService.addSale(sales);
    }
}
