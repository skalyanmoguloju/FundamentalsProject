package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import java.text.SimpleDateFormat;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class UserSteps {

    private User user;

    @Given("^user is set up$")
    public void user_is_set_up() throws Throwable {
        user = new User();
    }

    @When("^id (\\d+) is set$")
    public void id_is_set(int arg1) throws Throwable {
        user.setId(arg1);
    }

    @Then("^getId returns (\\d+)$")
    public void getid_returns(int arg1) throws Throwable {
        Assert.assertEquals(user.getId(), arg1, 1E-15);
    }

    @When("^name \"([^\"]*)\" is set$")
    public void name_is_set(String arg1) throws Throwable {
        user.setName(arg1);
    }

    @Then("^getName returns \"([^\"]*)\"$")
    public void getname_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getName(), arg1);
    }

    @When("^last name \"([^\"]*)\" is set$")
    public void last_name_is_set(String arg1) throws Throwable {
        user.setLname(arg1);
    }

    @Then("^getLname returns \"([^\"]*)\"$")
    public void getlname_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getLname(), arg1);
    }

    @When("^email \"([^\"]*)\" is set$")
    public void email_is_set(String arg1) throws Throwable {
        user.setEmail(arg1);
    }

    @Then("^getEmail returns \"([^\"]*)\"$")
    public void getemail_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getEmail(), arg1);
    }

    @When("^password \"([^\"]*)\" is set$")
    public void password_is_set(String arg1) throws Throwable {
        user.setPwsd(arg1);
    }

    @Then("^getPwsd returns \"([^\"]*)\"$")
    public void getpwsd_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getPwsd(), arg1);
    }

    @When("^date \"([^\"]*)\" is set$")
    public void date_is_set(String arg1) throws Throwable {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        user.setDob(formatter.parse(arg1));
    }

    @Then("^getDob returns \"([^\"]*)\"$")
    public void getdob_returns(String arg1) throws Throwable {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals(user.getDob(), formatter.parse(arg1));
    }

    @When("^role \"([^\"]*)\" is set$")
    public void role_is_set(String arg1) throws Throwable {
        user.setRole(arg1);
    }

    @Then("^getRole returns \"([^\"]*)\"$")
    public void getrole_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getRole(), arg1);
    }

    @When("^status \"([^\"]*)\" is set$")
    public void status_is_set(String arg1) throws Throwable {
        user.setStatus(arg1);
    }

    @Then("^getStatus returns \"([^\"]*)\"$")
    public void getstatus_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getStatus(), arg1);
    }

    @When("^gender \"([^\"]*)\" is set$")
    public void gender_is_set(String arg1) throws Throwable {
        user.setGender(arg1);
    }

    @Then("^getGender returns \"([^\"]*)\"$")
    public void getgender_returns(String arg1) throws Throwable {
        Assert.assertEquals(user.getGender(), arg1);
    }
}
