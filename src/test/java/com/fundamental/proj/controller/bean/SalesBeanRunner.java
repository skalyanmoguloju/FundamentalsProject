package com.fundamental.proj.controller.bean;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Madeline on 3/21/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/SalesBean.feature"
)
public class SalesBeanRunner {
}
