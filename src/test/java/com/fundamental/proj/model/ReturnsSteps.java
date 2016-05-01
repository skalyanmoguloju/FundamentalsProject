package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class ReturnsSteps {

    private Returns returns;

    @Given("^Returns is set up$")
    public void returns_is_set_up() throws Throwable {
        returns = new Returns();
    }

    @When("^res \"(.*?)\" is set$")
    public void res_is_set(String arg1) throws Throwable {
        returns.setResolution(arg1);
    }

    @Then("^getResolution returns \"(.*?)\"$")
    public void getresolution_returns(String arg1) throws Throwable {
        Assert.assertEquals(returns.getResolution(), arg1);
    }

    private Date date;
    @When("^date is set$")
    public void date_is_set() throws Throwable {
        date = new Date();
        returns.setReturn_date(date);
    }

    @Then("^getReturn_date returns that date$")
    public void getreturn_date_returns_that_date() throws Throwable {
        Assert.assertEquals(returns.getReturn_date(), date);
    }

    @When("^count (\\d+) is set$")
    public void count_is_set(int arg1) throws Throwable {
        returns.setReturn_count(arg1);
    }

    @Then("^getReturn_count returns (\\d+)$")
    public void getreturn_count_returns(int arg1) throws Throwable {
        Assert.assertEquals(returns.getReturn_count(), arg1);
    }

    @When("^rid (\\d+) is set$")
    public void rid_is_set(int arg1) throws Throwable {
        returns.setReturn_id(arg1);
    }

    @Then("^getReturn_id returns (\\d+)$")
    public void getreturn_id_returns(int arg1) throws Throwable {
        Assert.assertEquals(returns.getReturn_id(), arg1);
    }

    @When("^\"(.*?)\" is set$")
    public void is_set(String arg1) throws Throwable {
        returns.setDescription(arg1);
    }

    @Then("^getDescription returns \"(.*?)\"$")
    public void getdescription_returns(String arg1) throws Throwable {
        Assert.assertEquals(returns.getDescription(), arg1);
    }

    Orders orders;
    @When("^orders is set$")
    public void orders_is_set() throws Throwable {
        orders = new Orders();
        returns.setOrders(orders);
    }

    @Then("^getOrders returns that orders$")
    public void getorders_returns_that_orders() throws Throwable {
        Assert.assertEquals(returns.getOrders(), orders);
    }

}
