package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.mapper.OrdersBeanMapper;
import com.fundamental.proj.mapper.OrdersBeanMapperRunner;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.service.OrdersService;
import com.fundamental.proj.service.RolesService;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class OrdersDelegateSteps {
    @Mock
    private OrdersService mockedOrdersService;

    @Mock
    private OrdersBeanMapper mockedOrdersBeanMapper;

    @Mock
    private List<Orders> mockedListOrders;

    @InjectMocks
    private OrdersDelegate ordersDelegate;

    private List<OrdersBean> expectedListOrdersBean;
    private List<Long> expectedListTotalSold;

    @Given("^OrdersDelegate is set up$")
    public void ordersdelegate_is_set_up() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedOrdersBeanMapper, mockedOrdersService, mockedListOrders);
    }

    @When("^getAllOrderss is called$")
    public void getallorderss_is_called() throws Throwable {
        expectedListOrdersBean = new ArrayList<OrdersBean>();
        expectedListOrdersBean.add(new OrdersBean());
        Mockito.when(mockedOrdersService.getAllOrders(Mockito.anyLong())).thenReturn(mockedListOrders);
        Mockito.when(mockedOrdersBeanMapper.mapOrdersBean(mockedListOrders)).thenReturn(expectedListOrdersBean);
    }

    @Then("^getAllOrderss returns ordersBeans$")
    public void getallorderss_returns_ordersBeans() throws Throwable {
        List<OrdersBean> actualListOrdersBean = ordersDelegate.getAllOrderss(1L);

        Assert.assertEquals(actualListOrdersBean.size(), expectedListOrdersBean.size());
        Assert.assertEquals(actualListOrdersBean.get(0), expectedListOrdersBean.get(0));
        Mockito.verify(mockedOrdersService).getAllOrders(1L);
        Mockito.verify(mockedOrdersBeanMapper).mapOrdersBean(mockedListOrders);
    }

    @When("^getOrders is called$")
    public void getorders_is_called() throws Throwable {
        expectedListOrdersBean = new ArrayList<OrdersBean>();
        expectedListOrdersBean.add(new OrdersBean());
        Mockito.when(mockedOrdersService.getOrder(Mockito.anyLong())).thenReturn(mockedListOrders);
        Mockito.when(mockedOrdersBeanMapper.mapOrdersBean(mockedListOrders)).thenReturn(expectedListOrdersBean);
    }

    @Then("^getOrders returns ordersBeans$")
    public void getorders_returns_ordersBeans() throws Throwable {
        List<OrdersBean> actualListOrdersBean = ordersDelegate.getOrders(2L);

        Assert.assertEquals(actualListOrdersBean.size(), expectedListOrdersBean.size());
        Assert.assertEquals(actualListOrdersBean.get(0), expectedListOrdersBean.get(0));

        Mockito.verify(mockedOrdersService).getOrder(2L);
        Mockito.verify(mockedOrdersBeanMapper).mapOrdersBean(mockedListOrders);
    }

    @When("^getReceivedORders is called$")
    public void getreceivedorders_is_called() throws Throwable {
        expectedListOrdersBean = new ArrayList<OrdersBean>();
        expectedListOrdersBean.add(new OrdersBean());
        Mockito.when(mockedOrdersService.getReceivedOrders(Mockito.anyLong())).thenReturn(mockedListOrders);
        Mockito.when(mockedOrdersBeanMapper.mapOrdersBean(mockedListOrders)).thenReturn(expectedListOrdersBean);
    }

    @Then("^getReceivedORders returns ordersBeans$")
    public void getreceivedorders_returns_ordersBeans() throws Throwable {
        List<OrdersBean> actualListOrdersBean = ordersDelegate.getReceivedORders(2L);

        Assert.assertEquals(actualListOrdersBean.size(), expectedListOrdersBean.size());
        Assert.assertEquals(actualListOrdersBean.get(0), expectedListOrdersBean.get(0));

        Mockito.verify(mockedOrdersService).getReceivedOrders(2L);
        Mockito.verify(mockedOrdersBeanMapper).mapOrdersBean(mockedListOrders);
    }

    @When("^udpateOrders is called$")
    public void udpateorders_is_called() throws Throwable {
        Mockito.doNothing().when(mockedOrdersService).udpateOrders(Mockito.anyLong());
    }

    @Then("^udpateOrders is called successfully$")
    public void udpateorders_is_called_successfully() throws Throwable {
        ordersDelegate.udpateOrders(1L);
        Mockito.verify(mockedOrdersService).udpateOrders(1L);
    }

    @When("^getTotalSold is called$")
    public void gettotalsold_is_called() throws Throwable {
        expectedListTotalSold = new ArrayList<Long>();
        expectedListTotalSold.add(1L);
        Mockito.when(mockedOrdersService.getTotalSold(Mockito.anyLong())).thenReturn(expectedListTotalSold);
    }

    @Then("^getTotalSold returns totalsold$")
    public void gettotalsold_returns_totalsold() throws Throwable {
        List<Long> actualList = ordersDelegate.getTotalSold(1L);
        Assert.assertEquals(actualList.size(), expectedListTotalSold.size());
        Assert.assertEquals(actualList.get(0), expectedListTotalSold.get(0));
        Mockito.verify(mockedOrdersService).getTotalSold(1L);
    }

}
