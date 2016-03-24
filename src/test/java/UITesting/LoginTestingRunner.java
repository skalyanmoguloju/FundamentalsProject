package UITesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Daniel Dao on 3/12/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "json:target/cucumber" },
        features = "classpath:cucumber/LogInTesting.feature"
)
public class LogInTestingRunner {
    // Run LogInTesting.feature based on LogInTestingSteps.java
}
