package com.fundamental.proj.repository;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Orders;
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

public class OrdersRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private OrdersRepository ordersRepository;

    private List<Orders> expectedListOrders;
    private List<Long> expectedTotalSold;

    /************************************************/
    /*
     * Test getAllOrders()
     */
    /***********************************************/
    @Given("^mock OrdersRepository is initialized$")
    public void mock_OrdersRepository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);    }

    @When("^getAllOrders\\(\\) is called$")
    public void getallorders_is_called() throws Throwable {
        expectedListOrders = new ArrayList<Orders>();
        expectedListOrders.add(new Orders());

        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Orders where materialIndent.user.id=:uid order by order_id")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("uid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListOrders);
    }

    @Then("^getAllOrders returns a list of orders$")
    public void getallorders_returns_a_list_of_orders() throws Throwable {
        List<Orders> actualListOrders = ordersRepository.getAllOrders(1L);

        Assert.assertEquals(actualListOrders.size(), expectedListOrders.size());
        Assert.assertEquals(actualListOrders.get(0), expectedListOrders.get(0));
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from Orders where materialIndent.user.id=:uid order by order_id");
        Mockito.verify(mockedQuery).setParameter("uid", 1L);
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test getTotalSold()
     */
    /***********************************************/

    @When("^getTotalSold\\(\\) is called$")
    public void gettotalsold_is_called() throws Throwable {
        expectedTotalSold = new ArrayList<Long>();
        expectedTotalSold.add(3L);

        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery(Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("iid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedTotalSold);
    }

    @Then("^getTotalSold returns total sold$")
    public void gettotalsold_returns_total_sold() throws Throwable {
        List<Long> actualTotalSold = ordersRepository.getTotalSold(1L);

        Assert.assertEquals(actualTotalSold.size(), expectedTotalSold.size());
        Assert.assertEquals(actualTotalSold.get(0), expectedTotalSold.get(0) + expectedTotalSold.get(0), 1E-14);
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedQuery, Mockito.atLeastOnce()).list();
    }


    @When("^getOrderById\\(\\) is called$")
    public void getorderbyid_is_called() throws Throwable {
        expectedListOrders = new ArrayList<Orders>();
        expectedListOrders.add(new Orders());

        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Orders where order_id=:oid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("oid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListOrders);
    }

    @Then("^getOrderById returns a list of orders$")
    public void getorderbyid_returns_a_list_of_orders() throws Throwable {
        List<Orders> result = ordersRepository.getOrderById(1L);
        Assert.assertEquals(result.size(), expectedListOrders.size());
        Assert.assertEquals(result.get(0), expectedListOrders.get(0));
    }

    @When("^getReceivedOrders\\(\\) is called$")
    public void getreceivedorders_is_called() throws Throwable {
        expectedListOrders = new ArrayList<Orders>();
        expectedListOrders.add(new Orders());

        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Orders where items.user_id=:uid order by purchase_date")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("uid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListOrders);
    }

    @Then("^getReceivedOrders returns a list of orders$")
    public void getreceivedorders_returns_a_list_of_orders() throws Throwable {
        List<Orders> result = ordersRepository.getReceivedOrders(1L);
        Assert.assertEquals(result.size(), expectedListOrders.size());
        Assert.assertEquals(result.get(0), expectedListOrders.get(0));
    }

    @When("^udpateOrders\\(\\) is called$")
    public void udpateorders_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("update Orders set status=:val, delivery_date=:val2 where order_id=:iid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("iid"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("val"), Mockito.eq("Delivered"))).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("val2"), Mockito.any(Date.class))).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^udpateOrders has been called successfully$")
    public void udpateorders_has_been_called_successfully() throws Throwable {
        ordersRepository.udpateOrders(1L);
    }

}
