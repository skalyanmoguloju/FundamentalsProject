package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.OrdersBean;
import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.mapper.OrdersBeanMapper;
import com.fundamental.proj.mapper.SalesBeanMapper;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Sales;
import com.fundamental.proj.service.OrdersService;
import com.fundamental.proj.service.SalesService;
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

public class SalesDelegateSteps {
    @Mock
    private SalesService mockedSalesService;

    @Mock
    private SalesBeanMapper mockedSalesBeanMapper;

    @Mock
    private Sales mockedSales;

    @InjectMocks
    private SalesDelegate salesDelegate;

    @Given("^SalesDelegate is set up$")
    public void salesdelegate_is_set_up() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSalesBeanMapper, mockedSalesService, mockedSales);
    }

    @When("^addSale is called$")
    public void addsale_is_called() throws Throwable {
        Mockito.when(mockedSalesBeanMapper.mapBeanToSales(Mockito.any(SalesBean.class))).thenReturn(mockedSales);
        Mockito.doNothing().when(mockedSalesService).addSale(mockedSales);
    }

    @Then("^addSale runs successfully$")
    public void addsale_runs_successfully() throws Throwable {
        SalesBean salesBean = new SalesBean();
        salesDelegate.addSale(salesBean);

        Mockito.verify(mockedSalesBeanMapper).mapBeanToSales(salesBean);
        Mockito.verify(mockedSalesService).addSale(mockedSales);
    }

}
