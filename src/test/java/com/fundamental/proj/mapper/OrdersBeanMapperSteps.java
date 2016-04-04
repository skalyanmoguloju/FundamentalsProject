package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Orders;
import com.sun.org.apache.xpath.internal.operations.Or;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Daniel Dao on 3/8/16.
 */
public class OrdersBeanMapperSteps {

    private OrdersBeanMapper ordersBeanMapper;

    private Orders orders;
    private Orders expectedOrders;

    private OrdersBean ordersBean;
    private OrdersBean expectedOrdersBean;

    private List<Orders> listOrders;
    private List<OrdersBean> listOrdersBean;
    /************************************************/
    /*
     * Test mapOrdersBean()
     */

    /***********************************************/
    @Given("^OrdersBeanMapper is initialized$")
    public void ordersbeanmapper_is_initialized() throws Throwable {
        ordersBeanMapper = new OrdersBeanMapper();
    }

    @When("^mapOrdersBean is called for OrdersBeanMapper$")
    public void mapordersbean_is_called_for_OrdersBeanMapper() throws Throwable {
        orders = new Orders();
        orders.setItems(new Items());
        orders.setMaterialIndent(new MaterialIndent());
        expectedOrdersBean = ordersBeanMapper.mapOrdersBean(orders);
    }

    @Then("^mapOrdersBean returns a materialIndentBean$")
    public void mapordersbean_returns_a_materialIndentBean() throws Throwable {

    }

    /************************************************/
    /*
     * Test mapBeanToOrders()
     */

    /***********************************************/
    @When("^mapBeanToOrders is called for OrdersBeanMapper$")
    public void mapbeantoorders_is_called_for_OrdersBeanMapper() throws Throwable {
        ordersBean = new OrdersBean();
        ordersBean.setMaterialIndentBean(new MaterialIndentBean());
        ordersBean.setItemsBean(new ItemsBean());
        expectedOrders = ordersBeanMapper.mapBeanToOrders(ordersBean);
    }

    @Then("^mapBeanToOrders returns an orders$")
    public void mapbeantoorders_returns_an_orders() throws Throwable {

    }

    /************************************************/
    /*
     * Test mapOrdersBean(List)
     */

    /***********************************************/
    @When("^mapOrdersBeanList is called for OrdersBeanMapper$")
    public void mapordersbeanlist_is_called_for_OrdersBeanMapper() throws Throwable {
        listOrders = new ArrayList<Orders>();

        listOrdersBean = ordersBeanMapper.mapOrdersBean(listOrders);
    }

    @Then("^mapOrdersBean returns a list of ordersBeans$")
    public void mapordersbean_returns_a_list_of_ordersBeans() throws Throwable {

    }

}
