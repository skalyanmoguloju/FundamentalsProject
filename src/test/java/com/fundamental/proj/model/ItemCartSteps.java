package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Madeline on 3/23/16.
 */
public class ItemCartSteps {

    private ItemCart itemCart;

    @Given("^mock ItemCart is initialized$")
    public void mock_ItemCart_is_initialized() throws Throwable {

    }

    @When("^itemcart is called$")
    public void itemcart_is_called() throws Throwable {
        itemCart = new ItemCart();
    }

    @Then("^a list of items is returned$")
    public void a_list_of_items_is_returned() throws Throwable {

    }

}
