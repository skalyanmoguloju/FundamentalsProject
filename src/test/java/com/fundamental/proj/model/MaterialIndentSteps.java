package com.fundamental.proj.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel Dao.
 */
public class MaterialIndentSteps {

    private MaterialIndent materialIndent;

    @Given("^items is set up for MaterialIndent$")
    public void items_is_set_up_for_MaterialIndent() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^items user_id (\\d+) is set for MaterialIndent$")
    public void items_user_id_is_set_for_MaterialIndent(int arg1) throws Throwable {
        materialIndent.getUser().setId(arg1);
    }

    @Then("^items getUser_id returns (\\d+) for MaterialIndent$")
    public void items_getUser_id_returns_for_MaterialIndent(int arg1) throws Throwable {
        Assert.assertEquals(materialIndent.getUser(), arg1);
    }

    @Given("^indent_id is set up for MaterialIndent$")
    public void indent_id_is_set_up_for_MaterialIndent() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^indent_id (\\d+) is set for MaterialIndent$")
    public void indent_id_is_set_for_MaterialIndent(int arg1) throws Throwable {
        materialIndent.setIndent_id(arg1);
    }

    @Then("^getIndent_id returns (\\d+) for MaterialIndent$")
    public void getindent_id_returns_for_MaterialIndent(int arg1) throws Throwable {
        Assert.assertEquals(materialIndent.getIndent_id(), arg1);
    }

    @Given("^indent_date is set up$")
    public void indent_date_is_set_up() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    private Date date;
    @When("^indent_date is set$")
    public void indent_date_is_set() throws Throwable {
        date = new Date();
        materialIndent.setIndent_date(date);
    }

    @Then("^getIndent_date returns that date$")
    public void getindent_date_returns_that_date() throws Throwable {
        Assert.assertEquals(materialIndent.getIndent_date(), date);
    }

    @Given("^price is set up$")
    public void price_is_set_up() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^price (\\d+) is set for MaterialIndent$")
    public void price_is_set_for_MaterialIndent(int arg1) throws Throwable {
        materialIndent.setPrice(arg1);
    }

    @Then("^getPrice returns (\\d+) for MaterialIndent$")
    public void getprice_returns_for_MaterialIndent(int arg1) throws Throwable {
        Assert.assertEquals(materialIndent.getPrice(), arg1, 1E-15);
    }

    @Given("^cart_number is set up$")
    public void cart_number_is_set_up() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^cart_number \"(.*?)\" is set$")
    public void cart_number_is_set(String arg1) throws Throwable {
        materialIndent.setCard_number(arg1);
    }

    @Then("^getCard_number returns \"(.*?)\" for MaterialIndent$")
    public void getcard_number_returns_for_MaterialIndent(String arg1) throws Throwable {
        Assert.assertEquals(materialIndent.getCard_number(), arg1);
    }

    @Given("^cvv is set up$")
    public void cvv_is_set_up() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^cvv \"(.*?)\" is set$")
    public void cvv_is_set(String arg1) throws Throwable {
        materialIndent.setCard_cvv(arg1);
    }

    @Then("^getCard_cvv returns \"(.*?)\" for MaterialIndent$")
    public void getcard_cvv_returns_for_MaterialIndent(String arg1) throws Throwable {
        Assert.assertEquals(materialIndent.getCard_cvv(), arg1);
    }

    @Given("^exp is set up$")
    public void exp_is_set_up() throws Throwable {
        materialIndent = new MaterialIndent();
    }

    @When("^exp \"(.*?)\" is set$")
    public void exp_is_set(String arg1) throws Throwable {
        materialIndent.setCard_exp(arg1);
    }

    @Then("^getCard_exp returns \"(.*?)\"$")
    public void getcard_exp_returns(String arg1) throws Throwable {
        materialIndent.getCard_exp();
    }
}
