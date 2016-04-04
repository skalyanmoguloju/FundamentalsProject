package com.fundamental.proj.service;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Daniel Dao on 3/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/OrdersService.feature"
)
public class OrdersServiceRunner {
    // Run OrdersService.feature based on OrdersServiceSteps.java
}
