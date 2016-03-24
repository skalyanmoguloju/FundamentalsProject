package UITesting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel Dao on 3/12/16.
 */
public class LogInTestingSteps {

    private WebDriver driver;
    private String homeURL = "http://localhost:8080";

    @Given("^I have a browser opened for LogInTesting")
    public void i_have_a_browser_opened_login() throws Throwable {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
    }

    @And("^browser is closed for LogInTesting$")
    public void browser_is_closed_login() throws Throwable {
        driver.close();
    }

    @When("^I navigate to login page for LogInTesting$")
    public void i_navigate_to_login_page_login() throws Throwable {
        driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Then("^I should be in the login page for LogInTesting$")
    public void i_should_be_in_the_login_page_login() throws Throwable {
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Sign In");
    }

    @And("^I click submit for LogInTesting$")
    public void i_click_submit_login() throws Throwable {
        driver.findElement(By.id("lbltipAddedComment")).submit();
    }

    @When("^I enter \"([^\"]*)\" in email field for LogInTesting$")
    public void i_enter_in_email_field_login(String arg1) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(arg1);
    }

    @Then("^I should receive an please-enter email message$")
    public void i_should_receive_an_please_enter_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Please enter email id");
    }

    @Then("^I should not receive an please-enter email message and should receive a please-enter password$")
    public void i_should_not_receive_an_please_enter_email_message_and_should_receive_a_please_enter_password() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Please enter email id");
        Assert.assertEquals(msg, "Please enter password");
    }

    @Then("^I should not receive an please-enter email message and should not receive a please-enter password$")
    public void i_should_not_receive_an_please_enter_email_message_and_should_not_receive_a_please_enter_password() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Please enter email id");
        Assert.assertNotEquals(msg, "Please enter password");
    }

    @And("^I enter \"([^\"]*)\" in password field in login$")
    public void i_enter_in_password_field_login(String arg1) throws Throwable {
        driver.findElement(By.id("askpassword")).sendKeys(arg1);
    }

    @Then("^I should receive a wrong account$")
    public void i_should_receive_a_wrong_account() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Invalid Credentials!!");
    }

    @Then("^I should be navigated to home page$")
    public void i_should_be_navigated_to_home_page() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/home"));
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Home");
    }

    @Given("^I have registered for an account with email \"([^\"]*)\", password \"([^\"]*)\", and role \"([^\"]*)\"$")
    public void i_have_registered_for_an_account_with_email_password_and_role(String arg1, String arg2, String arg3) throws Throwable {

    }

    @Then("^I should receive an inactive account message$")
    public void i_should_receive_a_inactive_account() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        //Assert.assertEquals(msg, "Account Inactive!!");
    }

    @Given("^I have registered and activated for an account with email \"([^\"]*)\", password \"([^\"]*)\", and role \"([^\"]*)\"$")
    public void i_have_registered_and_activated_for_an_account_with_email_password_and_role(String arg1, String arg2, String arg3) throws Throwable {

    }

}