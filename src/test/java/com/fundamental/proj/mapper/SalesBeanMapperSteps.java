package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.model.Sales;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Daniel Dao on 3/8/16.
 */
public class SalesBeanMapperSteps {

    private SalesBeanMapper salesBeanMapper;

    private Sales sales;
    private Sales actualSales;

    private SalesBean salesBean;
    private SalesBean actualSalesBean;

    private List<Sales> listSales;
    private List<SalesBean> listSalesBean;
    /************************************************/
    /*
     * Test mapSalesBean()
     */
    /***********************************************/
    @Given("^SalesBeanMapper is initialized$")
    public void salesbeanmapper_is_initialized() throws Throwable {
        salesBeanMapper = new SalesBeanMapper();
    }

    @When("^mapSalesBean is called for SalesBeanMapper$")
    public void mapsalesbean_is_called_for_SalesBeanMapper() throws Throwable {
        salesBeanMapper = new SalesBeanMapper();

        sales = new Sales();
        sales.setCard_cvv("1234");
        sales.setCard_number("1234");
        sales.setExp_date("2012-01-01");
        sales.setItem_id(2L);
        sales.setPrice(3F);
        sales.setQuantity(3L);
        sales.setSale_id(3L);
        sales.setUser_id(1L);

        actualSalesBean = salesBeanMapper.mapSalesBean(sales);
    }

    @Then("^mapSalesBean returns a salesBean$")
    public void mapsalesbean_returns_a_salesBean() throws Throwable {
        Assert.assertEquals(actualSalesBean.getCard_cvv(), sales.getCard_cvv());
        Assert.assertEquals(actualSalesBean.getCard_number(), sales.getCard_number());
        Assert.assertEquals(actualSalesBean.getExp_date(), sales.getExp_date());
        Assert.assertEquals(actualSalesBean.getItem_id(), sales.getItem_id());
        Assert.assertEquals(actualSalesBean.getPrice(), sales.getPrice(), 1E-15);
        Assert.assertEquals(actualSalesBean.getQuantity(), sales.getQuantity());
        Assert.assertEquals(actualSalesBean.getSale_id(), sales.getSale_id());
        Assert.assertEquals(actualSalesBean.getUser_id(), sales.getUser_id());

    }

    /************************************************/
    /*
     * Test mapBeanToSales()
     */
    /***********************************************/

    @When("^mapBeanToSales is called for RolesBeanMapper$")
    public void mapbeantosales_is_called_for_RolesBeanMapper() throws Throwable {
        salesBean = new SalesBean();
        salesBean.setCard_cvv("1234");
        salesBean.setCard_number("1234");
        salesBean.setExp_date("2012-01-01");
        salesBean.setItem_id(2L);
        salesBean.setPrice(3F);
        salesBean.setQuantity(3L);
        salesBean.setSale_id(3L);
        salesBean.setUser_id(1L);

        actualSales = salesBeanMapper.mapBeanToSales(salesBean);
    }

    @Then("^mapBeanToSales returns a sales$")
    public void mapbeantosales_returns_a_sales() throws Throwable {
        Assert.assertEquals(actualSales.getCard_cvv(), salesBean.getCard_cvv());
        Assert.assertEquals(actualSales.getCard_number(), salesBean.getCard_number());
        Assert.assertEquals(actualSales.getExp_date(), salesBean.getExp_date());
        Assert.assertEquals(actualSales.getItem_id(), salesBean.getItem_id());
        Assert.assertEquals(actualSales.getPrice(), salesBean.getPrice(), 1E-15);
        Assert.assertEquals(actualSales.getQuantity(), salesBean.getQuantity());
        Assert.assertEquals(actualSales.getUser_id(), salesBean.getUser_id());
        Assert.assertEquals(actualSales.getSale_id(), salesBean.getSale_id());
    }

    /************************************************/
    /*
     * Test mapSalesBean(List)
     */
    /***********************************************/
    @When("^mapSalesBeanList is called for SalesBeanMapper$")
    public void mapsalesbeanlist_is_called_for_SalesBeanMapper() throws Throwable {
        listSales = new ArrayList<Sales>();
        sales = new Sales();
        sales.setCard_cvv("1234");
        sales.setCard_number("1234");
        sales.setExp_date("2012-01-01");
        sales.setItem_id(2L);
        sales.setPrice(3F);
        sales.setQuantity(3L);
        sales.setSale_id(3L);
        sales.setUser_id(1L);

        listSales.add(sales);
        listSalesBean = salesBeanMapper.mapSalesBean(listSales);

    }

    @Then("^mapSalesBeanList returns a list of salesBean$")
    public void mapsalesbeanlist_returns_a_list_of_salesBean() throws Throwable {
        Assert.assertEquals(listSalesBean.size(), listSales.size());

        for (int x=0; x<listSales.size(); x++) {
            Assert.assertEquals(listSales.get(x).getCard_cvv(), listSalesBean.get(x).getCard_cvv());
            Assert.assertEquals(listSales.get(x).getCard_number(), listSalesBean.get(x).getCard_number());
            Assert.assertEquals(listSales.get(x).getExp_date(), listSalesBean.get(x).getExp_date());
            Assert.assertEquals(listSales.get(x).getItem_id(), listSalesBean.get(x).getItem_id());
            Assert.assertEquals(listSales.get(x).getPrice(), listSalesBean.get(x).getPrice(), 1E-15);
            Assert.assertEquals(listSales.get(x).getQuantity(), listSalesBean.get(x).getQuantity());
            Assert.assertEquals(listSales.get(x).getUser_id(), listSalesBean.get(x).getUser_id());
            Assert.assertEquals(listSales.get(x).getSale_id(), listSalesBean.get(x).getSale_id());
        }
    }

}
