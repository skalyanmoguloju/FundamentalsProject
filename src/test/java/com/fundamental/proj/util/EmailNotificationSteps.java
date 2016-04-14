package com.fundamental.proj.util;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import java.util.UUID;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class EmailNotificationSteps {

    private EmailNotification emailNotification;
    private String[] arrKey;
    private String rKey = null;

    @Given("^I have an EmailVerification$")
    public void i_have_an_EmailVerification() throws Throwable {
        emailNotification = new EmailNotification();
    }

    @When("^I generate (\\d+) key\\(s\\)$")
    public void i_generate_key_s(int arg1) throws Throwable {
        arrKey = new String[arg1];
        for (int x = 0; x < arg1; x++) {
            arrKey[x] = emailNotification.generateKey();
        }
    }

    @When("^I call sendEmailVerificationLink$")
    public void i_call_sendEmailVerificationLink() throws Throwable {
        rKey = emailNotification.sendEmailVerificationLink("emailver.FSE.Group4@gmail.com", (long) 0);
    }

    @Then("^they should be different$")
    public void they_should_be_different() throws Throwable {
        if (arrKey.length > 1) {
            for (int x = 0; x < arrKey.length; x++) {
                String firstKey = arrKey[x];
                int ct = x+1;
                while (ct < arrKey.length) {
                    Assert.assertFalse(firstKey.equals(arrKey[ct]));
                    ct++;
                }
            }
        }
    }

    @Then("^each key should have the same length as a random UUID$")
    public void it_should_have_the_same_length_as_a_random_UUID() throws Throwable {
        for (String key : arrKey)
            Assert.assertEquals(key.length(), UUID.randomUUID().toString().length());
    }

    @Then("^it should return a key having the same length as a random UUID$")
    public void it_should_return_a_key_having_the_same_length_as_a_random_UUID() throws Throwable {
        Assert.assertEquals(rKey.length(), UUID.randomUUID().toString().length());
    }

}
