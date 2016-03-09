package com.fundamental.proj.util;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.UUID;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class EmailVerificationSteps {

    private EmailVerification emailVerification;
    private String[] arrKey;

    @Given("^I have an EmailVerification$")
    public void i_have_an_EmailVerification() throws Throwable {
        emailVerification = new EmailVerification();
    }

    @When("^I generate (\\d+) key\\(s\\)$")
    public void i_generate_key_s(int arg1) throws Throwable {
        arrKey = new String[arg1];
        for (int x = 0; x < arg1; x++) {
            arrKey[x] = emailVerification.generateKey();
        }
    }

    @Then("^they should be different$")
    public void they_should_be_different() throws Throwable {
        if (arrKey.length > 1) {
            for (int x = 0; x < arrKey.length; x++) {
                String firstKey = arrKey[x];
                int ct = x+1;
                while (ct < arrKey.length) {
                    assertFalse(firstKey.equals(arrKey[ct]));
                    ct++;
                }
            }
        }
    }

    @Then("^it should have the same length as a random UUID$")
    public void it_should_have_the_same_length_as_a_random_UUID() throws Throwable {
        for (String key : arrKey)
            assertEquals(key.length(), UUID.randomUUID().toString().length());
    }
}
