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
        features = "classpath:cucumber/MaterialIndentService.feature"
)
public class MaterialIndentServiceRunner {
    // Run MaterialIndentService.feature based on MaterialIndentServiceSteps.java
}
