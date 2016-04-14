package com.fundamental.proj.util;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


/**
 * Created by Daniel Dao on 3/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/EmailNotification.feature"
)
public class EmailNotificationRunner {
    // Run EmailNotification.feature based on EmailNotificationSteps.java
}
