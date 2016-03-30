package com.fundamental.proj.controller.bean;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Madeline on 3/19/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/UserBean.feature"
)
public class UserBeanRunner {
    // Run UserBean.feature based on UserBeanSteps.java
}
