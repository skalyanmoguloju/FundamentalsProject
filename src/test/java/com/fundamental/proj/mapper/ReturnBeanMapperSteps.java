package com.fundamental.proj.mapper;


import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.model.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Daniel Dao on 3/8/16.
 */
public class ReturnBeanMapperSteps {

    private ReturnBeanMapper returnBeanMapper;

    private Returns returns;
    private ReturnBean expectedReturnBean;

    private ReturnBean returnBean;
    private Returns expectedReturns;

    private List<ReturnBean> expectedReturnBeanList;
    private List<Returns> listReturns;


    @Given("^ReturnBeanMapper is initialized$")
    public void returnbeanmapper_is_initialized() throws Throwable {
        returnBeanMapper = new ReturnBeanMapper();
    }

    @When("^mapReturnBean is called for ReturnBeanMapper$")
    public void mapreturnbean_is_called_for_ReturnBeanMapper() throws Throwable {
        returns = new Returns();
        Orders orders = new Orders();
        orders.setItems(new Items());
        MaterialIndent materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());
        orders.setMaterialIndent(materialIndent);
        returns.setDescription("des");
        returns.setOrders(orders);
        returns.setResolution("Res");
        returns.setReturn_count(3);
        returns.setReturn_date(new Date());
        returns.setReturn_id(1L);
        expectedReturnBean = returnBeanMapper.mapReturnBean(returns);
    }

    @Then("^mapReturnBean returns a returnbean$")
    public void mapreturnbean_returns_a_returnbean() throws Throwable {
        Assert.assertEquals(expectedReturnBean.getDescription(), returns.getDescription());
        Assert.assertEquals(expectedReturnBean.getResolution(), returns.getResolution());
        Assert.assertEquals(expectedReturnBean.getReturn_count(), returns.getReturn_count());
        Assert.assertEquals(expectedReturnBean.getReturn_date(), returns.getReturn_date());
        Assert.assertEquals(expectedReturnBean.getReturn_id(), returns.getReturn_id());
    }

    @When("^mapBeanToReturn is called for ReturnBeanMapper$")
    public void mapbeantoreturn_is_called_for_ReturnBeanMapper() throws Throwable {
        OrdersBean ordersBean = new OrdersBean();
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setCard_cvv("CBB");
        materialIndentBean.setCard_exp("exp");
        materialIndentBean.setCard_number("number");
        materialIndentBean.setIndent_date(new Date());
        materialIndentBean.setIndent_id(1L);
        materialIndentBean.setPrice(3);
        materialIndentBean.setAddressBean(new AddressBean());
        materialIndentBean.setUserBean(new UserBean());
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
        ordersBean.setMaterialIndentBean(materialIndentBean);
        ordersBean.setItemsBean(itemsBean);

        returnBean = new ReturnBean();
        returnBean.setReturn_id(1L);
        returnBean.setReturn_date(new Date());
        returnBean.setReturn_count(3);
        returnBean.setResolution("Res");
        returnBean.setDescription("Des");
        returnBean.setOrdersBean(ordersBean);
        expectedReturns = returnBeanMapper.mapBeanToReturn(returnBean);
    }

    @Then("^mapBeanToReturn returns a returns$")
    public void mapbeantoreturn_returns_a_returns() throws Throwable {
        Assert.assertEquals(expectedReturns.getDescription(), returnBean.getDescription());
        Assert.assertEquals(expectedReturns.getResolution(), returnBean.getResolution());
        Assert.assertEquals(expectedReturns.getReturn_count(), returnBean.getReturn_count());
        Assert.assertEquals(expectedReturns.getReturn_id(), returnBean.getReturn_id());
        Assert.assertEquals(expectedReturns.getReturn_date(), returnBean.getReturn_date());
    }

    @When("^mapReturnBeanList is called for ReturnBeanMapper$")
    public void mapreturnbeanlist_is_called_for_ReturnBeanMapper() throws Throwable {
        returns = new Returns();
        Orders orders = new Orders();
        orders.setItems(new Items());
        MaterialIndent materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());
        orders.setMaterialIndent(materialIndent);
        returns.setDescription("des");
        returns.setOrders(orders);
        returns.setResolution("Res");
        returns.setReturn_count(3);
        returns.setReturn_date(new Date());
        returns.setReturn_id(1L);

        listReturns = new ArrayList<Returns>();
        listReturns.add(returns);

        expectedReturnBeanList = returnBeanMapper.mapReturnBean(listReturns);
    }

    @Then("^mapReturnBean returns a list of returnbeans$")
    public void mapreturnbean_returns_a_list_of_returnbeans() throws Throwable {
        Assert.assertEquals(expectedReturnBeanList.size(), listReturns.size());
    }
}
