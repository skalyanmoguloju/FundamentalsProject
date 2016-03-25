package com.fundamental.proj.mapper;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Daniel Dao on 3/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/CartBeanMapper.feature"
)
public class CartBeanMapperRunner {
    // Run CartBeanMapper.feature based on CartBeanMapperSteps.java
}
