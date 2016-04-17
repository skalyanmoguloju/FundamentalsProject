package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.mapper.MaterialIndentMapper;
import com.fundamental.proj.mapper.SalesBeanMapper;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Sales;
import com.fundamental.proj.service.MaterialIndentService;
import com.fundamental.proj.service.SalesService;
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

public class MaterialIndentDelegateSteps {
    @Mock
    private MaterialIndentService mockedMaterialIndentService;

    @Mock
    private MaterialIndentMapper mockedMaterialIndentMapper;

    @Mock
    private MaterialIndent mockedMaterialIndent;

    @InjectMocks
    private MaterialIndentDelegate materialIndentDelegate;

    @Given("^MaterialIndentDelegate is set up$")
    public void MaterialIndentDelegate_is_set_up() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedMaterialIndent, mockedMaterialIndentMapper, mockedMaterialIndentService);
    }

    @When("^addSale is called for MaterialIndentDelegate$")
    public void addsale_is_called_for_MaterialIndentDelegate() throws Throwable {

        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        Address address =new Address();
        Mockito.when(mockedMaterialIndentMapper.mapBeanToMaterialIndent(Mockito.any(MaterialIndentBean.class))).thenReturn(mockedMaterialIndent);
        Mockito.doNothing().when(mockedMaterialIndentService).addSale(mockedMaterialIndent);
    }

    @Then("^addSale runs successfully for MaterialIndentDelegate$")
    public void addsale_runs_successfully_for_MaterialIndentDelegate() throws Throwable {
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        Address address =new Address();
        materialIndentDelegate.addSale(materialIndentBean);

        Mockito.verify(mockedMaterialIndentMapper).mapBeanToMaterialIndent(materialIndentBean);
        Mockito.verify(mockedMaterialIndentService).addSale(mockedMaterialIndent);
    }
}
