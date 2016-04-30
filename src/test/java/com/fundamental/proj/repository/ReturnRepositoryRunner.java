package com.fundamental.proj.repository;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Daniel Dao on 3/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/ReturnRepository.feature"
)
public class ReturnRepositoryRunner {
    // Run ReturnRepository.feature based on ReturnRepositorySteps.java
}
