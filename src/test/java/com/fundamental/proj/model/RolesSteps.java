package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class RolesSteps {

    private Roles roles;

    @Given("^Roles is set up$")
    public void roles_is_set_up() throws Throwable {
        roles = new Roles();
    }

    @When("^roles \"([^\"]*)\" is set$")
    public void roles_is_set(String arg1) throws Throwable {
        roles.setRole(arg1);
    }

    @Then("^getRole returns role \"([^\"]*)\"$")
    public void getrole_returns_role(String arg1) throws Throwable {
        Assert.assertEquals(roles.getRole(), arg1);
    }


    @When("^right \"([^\"]*)\" is set$")
    public void right_is_set(String arg1) throws Throwable {
        roles.setRights(arg1);
    }

    @Then("^gerRights returns right \"([^\"]*)\"$")
    public void getrights_returns_right(String arg1) throws Throwable {
        Assert.assertEquals(roles.getRights(), arg1);
    }

}
