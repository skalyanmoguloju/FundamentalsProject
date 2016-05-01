package com.fundamental.proj.repository;

import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Returns;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class ReturnRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @Mock
    private ItemsRepository mockedItemsRepository;

    @InjectMocks
    private ReturnRepository returnRepository;

    private List<Returns> expectedListReturns;
    private List<Orders> listOrders;

    @Given("^ReturnRepository is set up$")
    public void returnrepository_is_set_up() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery, mockedItemsRepository);
    }

    @When("^updateSaleCount is called$")
    public void updatesalecount_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("update Items set sold_count=:newQuant where item_id=:iid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("iid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("newQuant"), Mockito.anyInt())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockedSession).flush();

    }

    @Then("^updateSaleCount is called sucessfully$")
    public void updatesalecount_is_called_sucessfully() throws Throwable {
        returnRepository.updateSaleCount(1L, 3);
    }

    @When("^AddNewOrder is called$")
    public void addneworder_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).saveOrUpdate(Mockito.any(Orders.class));
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^AddNewOrder is called sucessfully$")
    public void addneworder_is_called_sucessfully() throws Throwable {
        returnRepository.AddNewOrder(new Orders());
    }

    @When("^returnRequest is called$")
    public void returnrequest_is_called() throws Throwable {
        listOrders = new ArrayList<Orders>();
        Orders orders = new Orders();
        orders.setQuantity(3);
        listOrders.add(orders);
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery(Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("order_id"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(listOrders);
        Mockito.when(mockedQuery.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^returnRequest is called sucessfully$")
    public void returnrequest_is_called_sucessfully() throws Throwable {
        Returns returns = new Returns();
        Orders orders = new Orders();
        orders.setOrder_id(1L);
        returns.setOrders(orders);
        returns.setReturn_count(3);

        returnRepository.returnRequest(returns);
    }

    @When("^AddReturn is called$")
    public void addreturn_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).saveOrUpdate(Mockito.any(Orders.class));
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^AddReturn is called sucessfully$")
    public void addreturn_is_called_sucessfully() throws Throwable {
       returnRepository.AddReturn(new Returns());
    }

    @Given("^list of returns is set up$")
    public void list_of_returns_is_set_up() throws Throwable {
        expectedListReturns = new ArrayList<Returns>();
        expectedListReturns.add(new Returns());
    }

    @When("^getAllOrders is called for ReturnRepository$")
    public void getallorders_is_called_for_ReturnRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Returns where orders.materialIndent.user.id=:uid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("uid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListReturns);
    }

    @Then("^list of returns is returned for getAllOrders$")
    public void list_of_returns_is_returned_for_getAllOrders() throws Throwable {
        List<Returns> result = returnRepository.getAllOrders(1L);
        Assert.assertEquals(result.size(), expectedListReturns.size());
        Assert.assertEquals(result.get(0), expectedListReturns.get(0));
    }

    @When("^getRetOrders is called for ReturnRepository$")
    public void getretorders_is_called_for_ReturnRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Returns where orders.materialIndent.user.id=:uid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("uid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListReturns);
    }

    @Then("^list of returns is returned for getRetOrders$")
    public void list_of_returns_is_returned_for_getRetOrders() throws Throwable {
        List<Returns> result = returnRepository.getRetOrders(1L);
        Assert.assertEquals(result.size(), expectedListReturns.size());
        Assert.assertEquals(result.get(0), expectedListReturns.get(0));
    }

    @When("^getRecRetOrders is called for ReturnRepository$")
    public void getrecretorders_is_called_for_ReturnRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Returns where orders.items.user_id=:uid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("uid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListReturns);
    }

    @Then("^list of returns is returned for getRecRetOrders$")
    public void list_of_returns_is_returned_for_getRecRetOrders() throws Throwable {
        List<Returns> result = returnRepository.getRecRetOrders(1L);
        Assert.assertEquals(result.size(), expectedListReturns.size());
        Assert.assertEquals(result.get(0), expectedListReturns.get(0));
    }

}
