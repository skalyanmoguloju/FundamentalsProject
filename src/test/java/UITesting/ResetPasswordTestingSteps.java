package UITesting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel Dao on 3/12/16.
 */
public class ResetPasswordTestingSteps {

    private WebDriver driver;
    private String resetPage = "localhost:8080/password_reset/";

    @Given("^I have a browser opened for ResetPasswordTesting")
    public void i_have_a_browser_opened() throws Throwable {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
    }

    @When("^I navigate to reset password page for id (\\d+)$")
    public void i_navigate_to_reset_password_page_for_id(int arg1) throws Throwable {
        driver.manage().window().maximize();
        driver.get(resetPage + arg1);
    }

    @Then("^I should be in the reset password page$")
    public void i_should_be_in_the_reset_password_page() throws Throwable {
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Password Reset");
    }

    @And("^browser is closed for ResetPasswordTesting")
    public void browser_is_closed() throws Throwable {
        driver.close();
    }

    @And("^I click submit for ResetPasswordTesting$")
    public void i_click_submit_for_ResetPasswordTesting() throws Throwable {
        //driver.findElement(By.xpath("//input[@class='btn btn-lg btn-success btn-block']/parent::form")).submit();
    }

    @Then("^I should receive empty password message$")
    public void i_should_receive_empty_password_message() throws Throwable {
        //String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        //Assert.assertEquals(msg, "New Password cannot be blank");
    }
}