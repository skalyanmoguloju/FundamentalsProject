package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.model.Sales;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/10/16.
 */
@Component
public class SalesBeanMapper {

    public SalesBean mapSalesBean(Sales sales){
        SalesBean salesBean = new SalesBean();
        salesBean.setCard_cvv(sales.getCard_cvv());
        salesBean.setCard_number(sales.getCard_number());
        salesBean.setExp_date(sales.getExp_date());
        salesBean.setItem_id(sales.getItem_id());
        salesBean.setPrice(sales.getPrice());
        salesBean.setQuantity(sales.getQuantity());
        salesBean.setSale_id(sales.getSale_id());
        salesBean.setUser_id(sales.getUser_id());
        return salesBean;
    }

    public Sales mapBeanToSales(SalesBean salesBean){
        Sales sales = new Sales();
        sales.setCard_cvv(salesBean.getCard_cvv());
        sales.setCard_number(salesBean.getCard_number());
        sales.setExp_date(salesBean.getExp_date());
        sales.setItem_id(salesBean.getItem_id());
        sales.setPrice(salesBean.getPrice());
        sales.setQuantity(salesBean.getQuantity());
        sales.setSale_id(salesBean.getSale_id());
        sales.setUser_id((salesBean.getUser_id()));
        return sales;
    }

    public List<SalesBean> mapSalesBean(List<Sales> saless)
    {
        List<SalesBean> salesBeans = new ArrayList<SalesBean>();
        for(Sales sales:saless){
            salesBeans.add((mapSalesBean(sales)));
        }
        return salesBeans;
    }
}
