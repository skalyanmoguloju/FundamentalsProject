package com.fundamental.proj.repository;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.model.MaterialIndent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class MaterialIndentRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    private MaterialIndentRepository materialIndentRepository;

    /************************************************/
    /*
     * Test AddSale()
     */
    /***********************************************/
    @Given("^mock MaterialIndentRepository is initialized$")
    public void mock_MaterialIndentRepository_is_initialized() throws Throwable {
        materialIndentRepository = new MaterialIndentRepository();
    }

    @When("^AddSale\\(\\) is called$")
    public void addsale_is_called() throws Throwable {
        materialIndentRepository.AddSale(new MaterialIndent(), new ArrayList<Cart>());
    }

    @Then("^it has been called successfully$")
    public void it_has_been_called_successfully() throws Throwable {

    }

    @When("^AddSale\\(\\) throws exception$")
    public void addsale_throws_exception() throws Throwable {

    }
}