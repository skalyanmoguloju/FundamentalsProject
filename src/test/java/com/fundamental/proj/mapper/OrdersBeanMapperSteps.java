package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.model.*;
import com.sun.mail.imap.protocol.Item;
import com.sun.org.apache.xpath.internal.operations.Or;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
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
        Items items = new Items();
        items.setCategory("categ");
        items.setDate(new Date());
        items.setImages("img");
        items.setItem_description("Description");
        items.setItem_id(1L);
        items.setItem_name("name");
        items.setOnsale_count(3);
        items.setPrice(3L);
        items.setSold_count(3);
        items.setUser_id(2L);

        MaterialIndent materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());

        orders = new Orders();
        orders.setItems(items);
        orders.setMaterialIndent(materialIndent);
        orders.setQuantity(3);
        orders.setStatus("Status");
        orders.setOrder_id(1);
        orders.setRejected_quantity(3);
        orders.setType("Type");
        orders.setDelivery_date(new Date());
        orders.setPurchase_date(new Date());
    }

    @Then("^mapOrdersBean returns a materialIndentBean$")
    public void mapordersbean_returns_a_materialIndentBean() throws Throwable {
        expectedOrdersBean = ordersBeanMapper.mapOrdersBean(orders);
        Assert.assertEquals(expectedOrdersBean.getDelivery_date(), orders.getDelivery_date());
        Assert.assertEquals(expectedOrdersBean.getOrder_id(), orders.getOrder_id());
        Assert.assertEquals(expectedOrdersBean.getQuantity(), orders.getQuantity());
        Assert.assertEquals(expectedOrdersBean.getRejected_quantity(), orders.getRejected_quantity());
        Assert.assertEquals(expectedOrdersBean.getPurchase_date(), orders.getPurchase_date());
        Assert.assertEquals(expectedOrdersBean.getStatus(), orders.getStatus());
        Assert.assertEquals(expectedOrdersBean.getType(), orders.getType());
    }

    /************************************************/
    /*
     * Test mapBeanToOrders()
     */

    /***********************************************/
    @When("^mapBeanToOrders is called for OrdersBeanMapper$")
    public void mapbeantoorders_is_called_for_OrdersBeanMapper() throws Throwable {
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setCategory("category");
        itemsBean.setDate(new Date());
        itemsBean.setImages("img");
        itemsBean.setItem_description("Description");
        itemsBean.setItem_id(3L);
        itemsBean.setItem_name("name");
        itemsBean.setOnsale_count(3);
        itemsBean.setPrice(30L);
        itemsBean.setSold_count(3);
        itemsBean.setUser_id(20L);
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setCard_cvv("CBB");
        materialIndentBean.setCard_exp("exp");
        materialIndentBean.setCard_number("number");
        materialIndentBean.setIndent_date(new Date());
        materialIndentBean.setIndent_id(1L);
        materialIndentBean.setPrice(3);
        materialIndentBean.setAddressBean(new AddressBean());
        materialIndentBean.setUserBean(new UserBean());

        ordersBean = new OrdersBean();
        ordersBean.setItemsBean(itemsBean);
        ordersBean.setMaterialIndentBean(materialIndentBean);
        ordersBean.setQuantity(3);
        ordersBean.setStatus("Status");
        ordersBean.setOrder_id(1);
        ordersBean.setRejected_quantity(3);
        ordersBean.setType("Type");
        ordersBean.setDelivery_date(new Date());
        ordersBean.setPurchase_date(new Date());
    }

    @Then("^mapBeanToOrders returns an orders$")
    public void mapbeantoorders_returns_an_orders() throws Throwable {
        expectedOrders = ordersBeanMapper.mapBeanToOrders(ordersBean);
        Assert.assertEquals(expectedOrders.getDelivery_date(), ordersBean.getDelivery_date());
        Assert.assertEquals(expectedOrders.getOrder_id(), ordersBean.getOrder_id());
        Assert.assertEquals(expectedOrders.getQuantity(), ordersBean.getQuantity());
        Assert.assertEquals(expectedOrders.getRejected_quantity(), ordersBean.getRejected_quantity());
        Assert.assertEquals(expectedOrders.getPurchase_date(), ordersBean.getPurchase_date());
        Assert.assertEquals(expectedOrders.getStatus(), ordersBean.getStatus());
        Assert.assertEquals(expectedOrders.getType(), ordersBean.getType());
    }

    /************************************************/
    /*
     * Test mapOrdersBean(List)
     */

    /***********************************************/
    @When("^mapOrdersBeanList is called for OrdersBeanMapper$")
    public void mapordersbeanlist_is_called_for_OrdersBeanMapper() throws Throwable {
        Items items = new Items();
        items.setCategory("categ");
        items.setDate(new Date());
        items.setImages("img");
        items.setItem_description("Description");
        items.setItem_id(1L);
        items.setItem_name("name");
        items.setOnsale_count(3);
        items.setPrice(3L);
        items.setSold_count(3);
        items.setUser_id(2L);

        MaterialIndent materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());

        orders = new Orders();
        orders.setItems(items);
        orders.setMaterialIndent(materialIndent);
        orders.setQuantity(3);
        orders.setStatus("Status");
        orders.setOrder_id(1);
        orders.setRejected_quantity(3);
        orders.setType("Type");
        orders.setDelivery_date(new Date());
        orders.setPurchase_date(new Date());

        listOrders = new ArrayList<Orders>();
        listOrders.add(orders);
    }

    @Then("^mapOrdersBean returns a list of ordersBeans$")
    public void mapordersbean_returns_a_list_of_ordersBeans() throws Throwable {
        listOrdersBean = ordersBeanMapper.mapOrdersBean(listOrders);
        expectedOrdersBean = listOrdersBean.get(0);
        Assert.assertEquals(listOrdersBean.size(), listOrders.size());
        Assert.assertEquals(expectedOrdersBean.getDelivery_date(), orders.getDelivery_date());
        Assert.assertEquals(expectedOrdersBean.getOrder_id(), orders.getOrder_id());
        Assert.assertEquals(expectedOrdersBean.getQuantity(), orders.getQuantity());
        Assert.assertEquals(expectedOrdersBean.getRejected_quantity(), orders.getRejected_quantity());
        Assert.assertEquals(expectedOrdersBean.getPurchase_date(), orders.getPurchase_date());
        Assert.assertEquals(expectedOrdersBean.getStatus(), orders.getStatus());
        Assert.assertEquals(expectedOrdersBean.getType(), orders.getType());
    }

}
