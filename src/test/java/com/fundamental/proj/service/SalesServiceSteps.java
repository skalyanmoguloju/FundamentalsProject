package com.fundamental.proj.service;

import com.fundamental.proj.model.Sales;
import com.fundamental.proj.repository.SalesRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class SalesServiceSteps {

    @Mock
    private SalesRepository mockedSalesRespository;

    @InjectMocks
    private SalesService salesService;

    @Given("^mock SalesService is initialized$")
    public void mock_salesservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSalesRespository);
    }

    /************************************************/
    /*
     * Test addSale()
     */
    /***********************************************/
    @When("^addSale\\(\\) is called$")
    public void addsale_is_called() throws Throwable {
        Mockito.doNothing().when(mockedSalesRespository).AddSale(Mockito.any(Sales.class));
    }

    @Then("^addSale has been called successfully called$")
    public void addsale_has_been_called_successfully_called() throws Throwable {
        Sales sales = new Sales();
        salesService.addSale(sales);

        // verify AddSale method is called
        Mockito.verify(mockedSalesRespository).AddSale(sales);
    }
}
