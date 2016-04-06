package com.fundamental.proj.service;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.repository.CartRepository;
import com.fundamental.proj.repository.MaterialIndentRepository;
import com.fundamental.proj.repository.OrdersRepository;
import com.sun.org.apache.xpath.internal.operations.Or;
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

public class OrdersServiceSteps {

    @Mock
    private OrdersRepository mockedOrdersRepository;

    @InjectMocks
    private OrdersService ordersService;

    private List<Orders> expectedListOrders;
    private List<Long> expectedListSoldCounts;
    /************************************************/
    /*
     * Test getAllOrders()
     */
    /***********************************************/
    @Given("^mock OrdersService is initialized$")
    public void mock_OrdersService_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedOrdersRepository);
    }

    @When("^getAllOrders\\(\\) is called for OrdersService$")
    public void getallorders_is_called_for_OrdersService() throws Throwable {
        expectedListOrders = new ArrayList<Orders>();
        expectedListOrders.add(new Orders());

        Mockito.when(mockedOrdersRepository.getAllOrders(Mockito.anyLong())).thenReturn(expectedListOrders);
    }

    @Then("^getAllOrders returns list of orders$")
    public void getallorders_returns_list_of_orders() throws Throwable {
        List<Orders> actualListOrders = ordersService.getAllOrders(1L);

        Assert.assertEquals(actualListOrders.size(), expectedListOrders.size());
        Assert.assertEquals(actualListOrders.get(0), expectedListOrders.get(0));
        Mockito.verify(mockedOrdersRepository).getAllOrders(1L);
    }

    /************************************************/
    /*
     * Test getTotalSold()
     */
    /***********************************************/
    @When("^getTotalSold\\(\\) is called for OrdersService$")
    public void getsoldcount_is_called_for_OrdersService() throws Throwable {
        expectedListSoldCounts = new ArrayList<Long>();
        expectedListSoldCounts.add(10L);

        Mockito.when(mockedOrdersRepository.getTotalSold(Mockito.anyLong())).thenReturn(expectedListSoldCounts);
    }

    @Then("^getTotalSold returns list of sold_counts$")
    public void getsoldcount_returns_list_of_sold_counts() throws Throwable {
        List<Long> actualListSoldCounts = ordersService.getTotalSold(1L);

        Assert.assertEquals(actualListSoldCounts.size(), expectedListSoldCounts.size());
        Assert.assertEquals(actualListSoldCounts.get(0), expectedListSoldCounts.get(0));
        Mockito.verify(mockedOrdersRepository).getTotalSold(1L);
    }
}
