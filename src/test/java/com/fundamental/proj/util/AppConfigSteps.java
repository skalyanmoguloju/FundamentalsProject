package com.fundamental.proj.util;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class AppConfigSteps {
    private AppConfig appConfig;
    private InternalResourceViewResolver internalResourceViewResolver = null;

    @Given("^I have an AppConfig$")
    public void i_have_an_AppConfig() throws Throwable {
        appConfig = new AppConfig();
    }

    @When("^I call viewResolver$")
    public void i_call_viewResolver() throws Throwable {
        internalResourceViewResolver = appConfig.viewResolver();
    }

    @Then("^I get back an InternalResourceViewResolver$")
    public void i_get_back_an_InternalResourceViewResolver() throws Throwable {
        Assert.assertNotEquals(internalResourceViewResolver, null);
    }
}
