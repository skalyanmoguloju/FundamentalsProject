package com.fundamental.proj.service;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * Created by Daniel Dao on 3/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/RolesService.feature"
)
public class RolesServiceRunner {
    // Run RolesService.feature based on RolesServiceSteps.java
}
