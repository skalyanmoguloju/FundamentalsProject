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
        features = "classpath:cucumber/ItemsService.feature"
)
public class ItemsServiceRunner {
    // Run ItemsService.feature based on ItemsServiceSteps.java
}
