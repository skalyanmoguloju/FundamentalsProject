package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class CartSteps {

    private Cart cart;
    private Items items;

    @Given("^Cart is set up$")
    public void cart_is_set_up() throws Throwable {
        cart = new Cart();
    }

    @When("^cart_id (\\d+) is set$")
    public void cart_id_is_set(int arg1) throws Throwable {
        cart.setCart_id(arg1);
    }

    @Then("^getCart_id returns cart_id (\\d+)$")
    public void getcart_id_returns_cart_id(int arg1) throws Throwable {
        Assert.assertEquals(cart.getCart_id(), arg1);
    }

    @When("^userid (\\d+) is set$")
    public void userid_is_set(int arg1) throws Throwable {
        cart.setUser_id(arg1);
    }

    @Then("^getUser_id returns user_id (\\d+)$")
    public void getuser_id_returns_user_id(int arg1) throws Throwable {
        Assert.assertEquals(cart.getUser_id(), arg1);
    }

    @When("^Quantity (\\d+) is set$")
    public void quantity_is_set(int arg1) throws Throwable {
        cart.setQuantity(arg1);
    }

    @Then("^getQuantity returns quantity (\\d+)$")
    public void getquantity_returns_quantity(int arg1) throws Throwable {
        Assert.assertEquals(cart.getQuantity(), arg1);
    }

    @When("^Price (\\d+) is set$")
    public void price_is_set(int arg1) throws Throwable {
        cart.setPrice(arg1);
    }

    @Then("^getPrice returns Price (\\d+)$")
    public void getprice_returns_Price(int arg1) throws Throwable {
        Assert.assertEquals(cart.getPrice(), arg1, 1E-15);
    }

    @When("^an item is set$")
    public void an_item_is_set() throws Throwable {
        items = new Items();
        items.setUser_id(2);
        items.setPrice(500);
        items.setSold_count(5);
        items.setItem_description("Description");
        items.setImages("img");
        items.setDate(new Date());
        items.setCategory("catag");
        items.setItem_name("name");
        items.setItem_id(1);
        items.setOnsale_count(5);

        cart.setItems(items);
    }

    @Then("^getItems returns that item$")
    public void getitems_returns_that_item() throws Throwable {
        Items actualItem = cart.getItems();

        Assert.assertEquals(actualItem.getUser_id(), items.getUser_id());
        Assert.assertEquals(actualItem.getPrice(), items.getPrice());
        Assert.assertEquals(actualItem.getSold_count(), items.getSold_count());
        Assert.assertEquals(actualItem.getItem_description(), items.getItem_description());
        Assert.assertEquals(actualItem.getImages(), items.getImages());
        Assert.assertEquals(actualItem.getDate(), items.getDate());
        Assert.assertEquals(actualItem.getCategory(), items.getCategory());
        Assert.assertEquals(actualItem.getItem_name(), items.getItem_name());
        Assert.assertEquals(actualItem.getItem_id(), items.getItem_id());
        Assert.assertEquals(actualItem.getOnsale_count(), items.getOnsale_count());

    }

}
