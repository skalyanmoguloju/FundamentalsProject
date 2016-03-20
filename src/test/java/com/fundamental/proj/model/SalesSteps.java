package com.fundamental.proj.model;

import cucumber.api.java.cs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class SalesSteps {

    private Sales sales;

    @Given("^sales is set up$")
    public void sales_is_set_up() throws Throwable {
        sales = new Sales();
    }

    @When("^sale_id (\\d+) is set$")
    public void sale_id_is_set(int arg1) throws Throwable {
        sales.setSale_id(arg1);
    }

    @Then("^getSale_id returns (\\d+)$")
    public void getsale_id_returns(int arg1) throws Throwable {
        Assert.assertEquals(sales.getSale_id(), arg1);
    }

    @When("^item_id (\\d+) is set$")
    public void item_id_is_set(int arg1) throws Throwable {
        sales.setItem_id(arg1);
    }

    @Then("^getItem_id returns (\\d+)$")
    public void getitem_id_returns(int arg1) throws Throwable {
        Assert.assertEquals(sales.getItem_id(), arg1);
    }

    @When("^user_id (\\d+) is set$")
    public void user_id_is_set(int arg1) throws Throwable {
        sales.setUser_id(arg1);
    }

    @Then("^getUser_id returns (\\d+)$")
    public void getuser_id_returns(int arg1) throws Throwable {
        Assert.assertEquals(sales.getUser_id(), arg1);
    }

    @When("^price (\\d+) is set$")
    public void price_is_set(int arg1) throws Throwable {
        sales.setPrice(arg1);
    }

    @Then("^getPrice returns (\\d+)$")
    public void getprice_returns(int arg1) throws Throwable {
        Assert.assertEquals(sales.getPrice(), arg1, 1E-15);
    }

    @When("^quantity (\\d+) is set$")
    public void quantity_is_set(int arg1) throws Throwable {
        sales.setQuantity(arg1);
    }

    @Then("^getQuantity returns (\\d+)$")
    public void getquantity_returns(int arg1) throws Throwable {
        Assert.assertEquals(sales.getQuantity(), arg1);
    }

    @When("^card_number \"([^\"]*)\" is set$")
    public void card_number_is_set(String arg1) throws Throwable {
        sales.setCard_number(arg1);
    }

    @Then("^getCard_number returns \"([^\"]*)\"$")
    public void getcard_number_returns(String arg1) throws Throwable {
        Assert.assertEquals(sales.getCard_number(), arg1);
    }

    @When("^exp_date \"([^\"]*)\" is set$")
    public void exp_date_is_set(String arg1) throws Throwable {
        sales.setExp_date(arg1);
    }

    @Then("^getExp_date returns \"([^\"]*)\"$")
    public void getexp_date_returns(String arg1) throws Throwable {
        Assert.assertEquals(sales.getExp_date(), arg1);
    }

    @When("^CVV \"([^\"]*)\" is set$")
    public void cvv_is_set(String arg1) throws Throwable {
        sales.setCard_cvv(arg1);
    }

    @Then("^getCard_cvv returns \"([^\"]*)\"$")
    public void getcard_cvv_returns(String arg1) throws Throwable {
        Assert.assertEquals(sales.getCard_cvv(), arg1);
    }
}
