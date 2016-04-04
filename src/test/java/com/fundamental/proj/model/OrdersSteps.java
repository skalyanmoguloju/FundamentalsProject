package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class OrdersSteps {

    private Orders orders;

    @Given("^Orders is set up$")
    public void orders_is_set_up() throws Throwable {
        orders = new Orders();
    }

    @When("^order_id (\\d+) is set$")
    public void order_id_is_set(int arg1) throws Throwable {
        orders.setOrder_id(arg1);
    }

    @Then("^getOrder_id returns order_id (\\d+)$")
    public void getorder_id_returns_order_id(int arg1) throws Throwable {
        Assert.assertEquals(orders.getOrder_id(), arg1);
    }

    private Items items = new Items();
    @When("^items is set$")
    public void items_is_set() throws Throwable {
        orders.setItems(items);
    }

    @Then("^getItems returns that items$")
    public void getitems_returns_that_items() throws Throwable {
        Assert.assertEquals(orders.getItems(), items);
    }

    @When("^status \"(.*?)\" is set for Orders$")
    public void status_is_set_for_Orders(String arg1) throws Throwable {
        orders.setStatus(arg1);
    }

    @Then("^getStatus returns \"(.*?)\" for Orders$")
    public void getstatus_returns_for_Orders(String arg1) throws Throwable {
        Assert.assertEquals(orders.getStatus(), arg1);
    }

    private MaterialIndent materialIndent = new MaterialIndent();
    @When("^materialindent is set for Orders$")
    public void materialindent_is_set_for_Orders() throws Throwable {
        orders.setMaterialIndent(materialIndent);
    }

    @Then("^getMaterialIndent returns that materialindent for Orders$")
    public void getmaterialindent_returns_that_materialindent_for_Orders() throws Throwable {
        Assert.assertEquals(orders.getMaterialIndent(), materialIndent);
    }

    @When("^quantity (\\d+) is set for Orders$")
    public void quantity_is_set_for_Orders(int arg1) throws Throwable {
        orders.setQuantity(arg1);
    }

    @Then("^getQuantity returns quantity (\\d+) for Orders$")
    public void getquantity_returns_quantity_for_Orders(int arg1) throws Throwable {
        Assert.assertEquals(orders.getQuantity(), arg1);
    }
}
