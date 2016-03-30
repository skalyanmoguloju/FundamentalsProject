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
        features = "classpath:cucumber/UserBeanMapper.feature"
)
public class UserBeanMapperRunner {
    // Run UserBeanMapper.feature based on UserBeanMapperSteps.java
}
