package com.fundamental.proj.repository;

import com.fundamental.proj.model.Sales;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Test;
import org.mockito.*;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class SalesRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private SalesRepository salesRepository;

    @Given("^mock SalesRepository is initialized$")
    public void mock_salesservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);
    }

    /************************************************/
    /*
     * Test AddSale()
     */
    /***********************************************/
    @When("^addSale\\(\\) is called$")
    public void addsale_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).persist(Mockito.any(Sales.class));
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^addSale has been called successfully called$")
    public void addsale_has_been_called_successfully_called() throws Throwable {
        Sales sales = new Sales();
        salesRepository.AddSale(sales);

        // verify AddSale method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).persist(sales);
        Mockito.verify(mockedSession).flush();
    }

    @When("^addSale\\(\\) is called incorrectly$")
    public void addsale_is_called_incorrectly() throws Throwable {
        BDDMockito.given(mockedSessionFactory.getCurrentSession()).willThrow(Exception.class);
    }

    @Then("^addSale throws exception$")
    @Test(expected=Exception.class)
    public void addsale_throws_exception() throws Throwable {
        Sales sales = new Sales();
        salesRepository.AddSale(sales);

        // verify AddSale method has been called
        Mockito.verify(mockedSessionFactory).getCurrentSession();
    }
}
