package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class AddressSteps {

    private Address address;


    @Given("^Address is set up$")
    public void address_is_set_up() throws Throwable {
        address = new Address();
    }

    @When("^address_Id (\\d+) is set$")
    public void address_id_is_set(int arg1) throws Throwable {
        address.setAddress_Id(arg1);
    }

    @Then("^getAddress_Id returns address_id (\\d+)$")
    public void getaddress_id_returns_address_id(int arg1) throws Throwable {
        Assert.assertEquals(address.getAddress_Id(), arg1);
    }

    @When("^user_id (\\d+) is set for Address$")
    public void user_id_is_set_for_Address(int arg1) throws Throwable {
        address.setUser_id(arg1);
    }

    @Then("^getUser_id returns user_id (\\d+) for Address$")
    public void getuser_id_returns_user_id_for_Address(int arg1) throws Throwable {
        Assert.assertEquals(address.getUser_id(), arg1);
    }

    @When("^line_1 \"(.*?)\" is set$")
    public void line1_is_set( String arg2) throws Throwable {
        address.setLine1(arg2);
    }

    @Then("^getLine_1 returns line_1 \"(.*?)\"$")
    public void getline1_returns_line1 (String arg3) throws Throwable {
        Assert.assertEquals(address.getLine1(), arg3);
    }

    @When("^line_2 \"(.*?)\" is set$")
    public void line2_is_set( String arg2) throws Throwable {
        address.setLine2(arg2);
    }

    @Then("^getLine_2 returns line_2 \"(.*?)\"$")
    public void getline2_returns_line2 (String arg3) throws Throwable {
        Assert.assertEquals(address.getLine2(), arg3);
    }

    @When("^city \"(.*?)\" is set$")
    public void city_is_set(String arg1) throws Throwable {
        address.setCity(arg1);
    }

    @Then("^getCity returns city \"(.*?)\"$")
    public void getcity_returns_city(String arg1) throws Throwable {
        Assert.assertEquals(address.getCity(), arg1);
    }

    @When("^state \"(.*?)\" is set$")
    public void state_is_set(String arg1) throws Throwable {
        address.setState(arg1);
    }

    @Then("^getState returns state \"(.*?)\"$")
    public void getstate_returns_state(String arg1) throws Throwable {
        Assert.assertEquals(address.getState(), arg1);

    }

    @When("^zip (\\d+) is set$")
    public void zip_is_set(int arg1) throws Throwable {
       address.setZip(arg1);
    }

    @Then("^getZip returns zip (\\d+)$")
    public void getzip_returns_zip(int arg1) throws Throwable {
        Assert.assertEquals(address.getZip(), arg1);
    }
}
