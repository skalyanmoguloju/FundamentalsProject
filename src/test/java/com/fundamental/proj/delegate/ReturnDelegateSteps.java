package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.controller.bean.ReturnBean;
import com.fundamental.proj.mapper.OrdersBeanMapper;
import com.fundamental.proj.mapper.ReturnBeanMapper;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Returns;
import com.fundamental.proj.service.OrdersService;
import com.fundamental.proj.service.ReturnService;
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

public class ReturnDelegateSteps {
    @Mock
    private ReturnService mockedReturnService;

    @Mock
    private ReturnBeanMapper mockedReturnBeanMapper;

    @Mock
    private Returns mockedReturns;

    @Mock
    private List<Returns> mockedListReturns;

    @InjectMocks
    private ReturnDelegate returnDelegate;

    private String returnReq;
    private List<ReturnBean> expectedListReturnBean;

    @Given("^ReturnDelegate is set up$")
    public void returnDelegate_is_set_up() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedReturnBeanMapper, mockedReturnService, mockedReturns, mockedListReturns);
    }

    @When("^returnRequest is called$")
    public void returnrequest_is_called() throws Throwable {
        returnReq = "return";
        Mockito.when(mockedReturnBeanMapper.mapBeanToReturn(Mockito.any(ReturnBean.class))).thenReturn(mockedReturns);
        Mockito.when(mockedReturnService.returnRequest(mockedReturns)).thenReturn(returnReq);
    }

    @Then("^returnRequest returns some returns$")
    public void returnrequest_returns_some_returns() throws Throwable {
        String result = returnDelegate.returnRequest(new ReturnBean());
        Assert.assertEquals(result, returnReq);
    }

    @When("^getRecRetOrders is called$")
    public void getrecretorders_is_called() throws Throwable {
        expectedListReturnBean = new ArrayList<ReturnBean>();
        expectedListReturnBean.add(new ReturnBean());
        Mockito.when(mockedReturnService.getRecRetOrders(Mockito.anyLong())).thenReturn(mockedListReturns);
        Mockito.when(mockedReturnBeanMapper.mapReturnBean(mockedListReturns)).thenReturn(expectedListReturnBean);
    }

    @Then("^getRecRetOrders returns some returnbeans$")
    public void getrecretorders_returns_some_returnbeans() throws Throwable {
        List<ReturnBean> list = returnDelegate.getRecRetOrders(1L);
        Assert.assertEquals(list.size(), expectedListReturnBean.size());
        Assert.assertEquals(list.get(0), expectedListReturnBean.get(0));
    }

    @When("^getRetOrders is called$")
    public void getretorders_is_called() throws Throwable {
        expectedListReturnBean = new ArrayList<ReturnBean>();
        expectedListReturnBean.add(new ReturnBean());
        Mockito.when(mockedReturnService.getRetOrders(Mockito.anyLong())).thenReturn(mockedListReturns);
        Mockito.when(mockedReturnBeanMapper.mapReturnBean(mockedListReturns)).thenReturn(expectedListReturnBean);
    }

    @Then("^getRetOrders returns some returnbeans$")
    public void getretorders_returns_some_returnbeans() throws Throwable {
        List<ReturnBean> list = returnDelegate.getRetOrders(1L);
        Assert.assertEquals(list.size(), expectedListReturnBean.size());
        Assert.assertEquals(list.get(0), expectedListReturnBean.get(0));
    }

}
