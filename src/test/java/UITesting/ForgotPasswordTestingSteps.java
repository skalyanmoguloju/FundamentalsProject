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
public class ForgotPasswordTestingSteps {

    private WebDriver driver;
    private String homeURL = "http://localhost:8080";

    @Given("^I have a browser opened for ForgotPasswordTesting")
    public void i_have_a_browser_opened() throws Throwable {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
    }

    @And("^browser is closed for ForgotPasswordTesting")
    public void browser_is_closed() throws Throwable {
        driver.close();
    }

    @When("^I navigate to forgot password page$")
    public void i_navigate_to_forgot_password_page() throws Throwable {
        driver.manage().window().maximize();
        driver.get(homeURL);
        driver.findElement(By.linkText("Forgot Password?")).click();

    }

    @Then("^I should be in the forgot password page$")
    public void i_should_be_in_the_forgot_password_page() throws Throwable {
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Forgot your password?");
    }


    @And("^I click submit for forgotPasswordTesting$")
    public void i_click_submit_forgot() throws Throwable {
        driver.findElement(By.id("lbltipAddedComment")).submit();
    }

    @Then("^I should receive an please-enter email message for ForgotPasswordTesting$")
    public void i_should_receive_an_please_enter_email_message_forgot() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Please enter email id");
    }

    @When("^I enter \"([^\"]*)\" in email field for ForgotPasswordTesting$")
    public void i_enter_in_email_field_forgot(String arg1) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(arg1);
    }

    @Then("^I should not receive an please-enter email message for ForgotPasswordTesting$")
    public void i_should_not_receive_an_please_enter_email_message_forgot() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Please enter email id");
    }

    @And("^I should receive a invalid email message$")
    public void i_should_receive_an_invalid_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Invalid Email Id!!!");
    }

    @Then("^I should not receive a invalid email message$")
    public void i_should_not_receive_a_invalid_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Invalid Email Id!!!");
    }

    @And("^I should receive confirm alert$")
    public void i_should_receive_confirm_alert() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
       Assert.assertEquals(driver.switchTo().alert().getText(), "Email has been sent to your email");
    }

    @When("^I click ok$")
    public void i_click_ok() throws Throwable {
        driver.switchTo().alert().accept();
    }

    @Then("^I should be in the login page for ForgotPasswordTesting$")
    public void i_should_be_in_the_login_page_login_forgot() throws Throwable {
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Sign In");
    }
}