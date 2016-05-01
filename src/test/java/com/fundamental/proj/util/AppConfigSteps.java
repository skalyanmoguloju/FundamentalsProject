package com.fundamental.proj.util;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class AppConfigSteps {

    private AppConfig appConfig;
    private InternalResourceViewResolver internalResourceViewResolver = null;

    @Mock
    ResourceHandlerRegistry mockedResourceHandlerRegistry;
    @Mock
    ResourceHandlerRegistration mockedResourceHandlerRegistration;
    @Mock
    DefaultServletHandlerConfigurer mockedDefaultServletHandlerConfigurer;

    @InjectMocks
    AppConfig injAppConfig;

    @Given("^I have an AppConfig$")
    public void i_have_an_AppConfig() throws Throwable {
        appConfig = new AppConfig();
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedDefaultServletHandlerConfigurer, mockedResourceHandlerRegistration, mockedResourceHandlerRegistry);
    }

    @When("^I call viewResolver$")
    public void i_call_viewResolver() throws Throwable {
        internalResourceViewResolver = appConfig.viewResolver();
    }

    @Then("^I get back an InternalResourceViewResolver$")
    public void i_get_back_an_InternalResourceViewResolver() throws Throwable {
        Assert.assertNotEquals(internalResourceViewResolver, null);
    }

    @When("^I call addResourceHandlers$")
    public void i_call_addResourceHandlers() throws Throwable {
        Mockito.when(mockedResourceHandlerRegistry.addResourceHandler(Mockito.anyString())).thenReturn(mockedResourceHandlerRegistration);
    }

    @Then("^addResourceHandlers runs successfully$")
    public void addresourcehandlers_runs_successfully() throws Throwable {
        injAppConfig.addResourceHandlers(mockedResourceHandlerRegistry);
    }

    @When("^I call configureDefaultServletHandling$")
    public void i_call_configureDefaultServletHandling() throws Throwable {
        Mockito.doNothing().when(mockedDefaultServletHandlerConfigurer).enable();
    }

    @Then("^configureDefaultServletHandling runs successfully$")
    public void configuredefaultservlethandling_runs_successfully() throws Throwable {
        injAppConfig.configureDefaultServletHandling(mockedDefaultServletHandlerConfigurer);
    }

}
