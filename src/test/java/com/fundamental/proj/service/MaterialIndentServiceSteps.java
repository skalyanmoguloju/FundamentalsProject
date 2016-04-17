package com.fundamental.proj.service;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.repository.CartRepository;
import com.fundamental.proj.repository.ItemsRepository;
import com.fundamental.proj.repository.MaterialIndentRepository;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class MaterialIndentServiceSteps {

    @Mock
    private MaterialIndentRepository mockedMaterialIndentRepository;

    @Mock
    private CartRepository mockedCartRepository;

    @Mock
    private List<Cart> mockedListCart;

    @InjectMocks
    private MaterialIndentService materialIndentService;
    /************************************************/
    /*
     * Test addSale()
     */
    /***********************************************/
    @Given("^mock MaterialIndentService is initialized$")
    public void mock_MaterialIndentService_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedCartRepository, mockedCartRepository, mockedListCart);
    }

    @When("^addSale\\(\\) is called for MaterialIndentService$")
    public void addsale_is_called_for_MaterialIndentService() throws Throwable {
        Mockito.doNothing().when(mockedCartRepository).ClearCart(Mockito.anyLong());
    }

    @Then("^addSale has been called successfully$")
    public void addsale_has_been_called_successfully() throws Throwable {

        materialIndentService.addSale(new MaterialIndent());
    }

}
