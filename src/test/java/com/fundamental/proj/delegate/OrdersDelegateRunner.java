package com.fundamental.proj.delegate;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Madeline on 3/26/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/OrdersDelegate.feature"
)
public class OrdersDelegateRunner {
    // Run OrdersDelegate.feature based on OrdersDelegateSteps.java
}
