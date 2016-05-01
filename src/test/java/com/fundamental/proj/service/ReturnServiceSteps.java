package com.fundamental.proj.service;

import com.fundamental.proj.model.Items;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Returns;
import com.fundamental.proj.repository.OrdersRepository;
import com.fundamental.proj.repository.ReturnRepository;
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

public class ReturnServiceSteps {

    @Mock
    private ReturnRepository mockedReturnRepository;

    @Mock
    private OrdersRepository mockedOrdersRepository;

    @InjectMocks
    private ReturnService returnService;

    private List<Returns> expectedListReturns;
    private Returns returns;

    @Given("^mock ReturnService is initialized$")
    public void mock_returnService_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedReturnRepository, mockedOrdersRepository);
    }

    @When("^returnRequest\\(\\) is called$")
    public void returnrequest_is_called() throws Throwable {
        returns = new Returns();
        Orders orders = new Orders();
        orders.setOrder_id(1L);
        Items items = new Items();
        items.setOnsale_count(3);
        items.setSold_count(2);
        orders.setItems(items);
        returns.setOrders(orders);
        returns.setReturn_count(1);
        List<Orders> ordersList = new ArrayList<Orders>();
        ordersList.add(orders);
        Mockito.doNothing().when(mockedReturnRepository).returnRequest(Mockito.any(Returns.class));
        Mockito.doNothing().when(mockedReturnRepository).AddNewOrder(Mockito.any(Orders.class));
        Mockito.when(mockedOrdersRepository.getOrderById(Mockito.anyLong())).thenReturn(ordersList);
        Mockito.doNothing().when(mockedReturnRepository).AddReturn(Mockito.any(Returns.class));
    }

    @Then("^returnRequest returns status$")
    public void returnrequest_returns_status() throws Throwable {
        String result = returnService.returnRequest(returns);
        Assert.assertEquals(result, "Full");
    }

    @Given("^list of returns is set up in ReturnService$")
    public void list_of_returns_is_set_up_in_ReturnService() throws Throwable {
        expectedListReturns = new ArrayList<Returns>();
        expectedListReturns.add(new Returns());
    }

    @When("^getRecRetOrders\\(\\) is called$")
    public void getrecretorders_is_called() throws Throwable {
        Mockito.when(mockedReturnRepository.getRecRetOrders(Mockito.anyLong())).thenReturn(expectedListReturns);
    }

    @Then("^getRecRetOrders returns some returns$")
    public void getrecretorders_returns_some_returns() throws Throwable {
        List<Returns> result = returnService.getRecRetOrders(1L);
        Assert.assertEquals(result.size(), expectedListReturns.size());
        Assert.assertEquals(result.get(0), expectedListReturns.get(0));
    }

    @When("^getRetOrders\\(\\) is called$")
    public void getretorders_is_called() throws Throwable {
        Mockito.when(mockedReturnRepository.getRetOrders(Mockito.anyLong())).thenReturn(expectedListReturns);
    }

    @Then("^getRetOrders returns some returns$")
    public void getretorders_returns_some_returns() throws Throwable {
        List<Returns> result = returnService.getRetOrders(1L);
        Assert.assertEquals(result.size(), expectedListReturns.size());
        Assert.assertEquals(result.get(0), expectedListReturns.get(0));
    }

}
