package UITesting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Daniel Dao on 3/12/16.
 */
public class UITestingSteps {

    private WebDriver driver;
    private String homeURL = "http://localhost:8080";

    @Given("^I have a browser opened")
    public void i_have_a_browser_opened() throws Throwable {
        driver = new FirefoxDriver();
    }

    @And("^browser is closed$")
    public void browser_is_closed() throws Throwable {
        driver.close();
    }

    /*
     * Sign Up Page Check
     */
    @When("^I navigate to signup page$")
    public void i_navigate_to_signup_page() throws Throwable {
        driver.manage().window().maximize();
        driver.get(homeURL);
        driver.findElement(By.linkText("Register")).click();

    }

    @Then("^I should be in the signup page$")
    public void i_should_be_in_the_signup_page() throws Throwable {
        String msg = driver.getTitle();
        Assert.assertEquals(msg, "Sign Up");
    }

    @And("^I click submit$")
    public void i_click_submit() throws Throwable {
        driver.findElement(By.id("lbltipAddedComment")).submit();
    }


    /*
     * First Name Check
     */
    @Then("^I should receive an empty first name message$")
    public void i_should_receive_an_error_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "First Name cannot be empty");
    }

    @And("^I enter \"([^\"]*)\" in first name field$")
    public void i_enter_in_first_name_field(String arg1) throws Throwable {
        driver.findElement(By.name("firstname")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty first name message$")
    public void i_should_not_receive_an_empty_first_name_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "First Name cannot be empty");
    }


    /*
     * Last Name Check
     */
    @And("^I enter \"([^\"]*)\" in last name field$")
    public void i_enter_in_last_name_field(String arg1) throws Throwable {
        driver.findElement(By.name("lastname")).sendKeys(arg1);
    }

    @Then("^I should receive an empty last name message$")
    public void i_should_receive_an_empty_last_name_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "Last Name cannot be empty");
    }

    @Then("^I should not receive an empty last name message$")
    public void i_should_not_receive_an_empty_last_name_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Last Name cannot be empty");
    }


    /*
     * Email Check
     */
    @Then("^I should receive an empty email message$")
    public void i_should_receive_an_empty_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "Email id cannot be empty");
    }

    @When("^I enter \"([^\"]*)\" in email field$")
    public void i_enter_in_email_field(String arg1) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty email message and should receive a wrong email message$")
    public void i_should_receive_a_wrong_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Email id cannot be empty");
        Assert.assertEquals(msg, "Invalid Email id entered!!");
    }

    @Then("^I should not receive a wrong email message or empty email message$")
    public void i_should_not_receive_a_wrong_email_message_or_empty_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Email id cannot be empty");
        Assert.assertNotEquals(msg, "Invalid Email id entered!!");
    }


    /*
     * Password Check
     */
    @Then("^I should receive an empty password message$")
    public void i_should_receive_an_empty_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "Password field cannot be empty");
    }

    @And("^I enter \"([^\"]*)\" in password field$")
    public void i_enter_in_password_field(String arg1) throws Throwable {
        driver.findElement(By.id("pswd")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty password message and should receive a 6-character message$")
    public void i_should_not_receive_an_empty_password_message_and_should_receive_a_6_character_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertEquals(msg, "Password must contain at least 6 characters");
    }

    @Then("^I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message$")
    public void i_should_not_receive_a_empty_password_message_and_should_not_receive_a_6_character_message_and_should_receive_an_aphanumeric_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertNotEquals(msg, "Password must contain at least 6 characters");
        Assert.assertEquals(msg, "Password must contain alphanumeric characters");

    }

    @Then("^I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message$")
    public void i_should_not_receive_a_empty_password_message_and_should_not_receive_a_6_character_message_and_should_not_receive_an_aphanumeric_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertNotEquals(msg, "Password must contain at least 6 characters");
        Assert.assertNotEquals(msg, "Password must contain alphanumeric characters");
    }


    /*
     * Confirm Password Check
     */
    @Then("^I should receive an empty confirm password message$")
    public void i_should_receive_an_empty_confirm_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "Confirm Password cannot be empty");
    }


    @And("^I enter \"([^\"]*)\" in confirm password field$")
    public void i_enter_in_confirm_password_field(String arg1) throws Throwable {
        driver.findElement(By.id("confirm_pswd")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty confirm password message$")
    public void i_should_not_receive_an_empty_confirm_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Confirm Password cannot be empty");
    }

    @And("^I should receive a non-matching password message$")
    public void i_should_receive_a_non_matching_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertEquals(msg, "Confirm Password does not match with Password");
    }

    @And("^I should not receive a non-matching password message$")
    public void i_should_not_receive_a_non_matching_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML").toString();
        Assert.assertNotEquals(msg, "Confirm Password does not match with Password");
    }


    /*
     *
     */
    //-----------------------------------------------------------------------------------------------------------------
}
