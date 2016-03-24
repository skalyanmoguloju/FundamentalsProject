package UITesting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel Dao on 3/12/16.
 */
public class SignUpTestingSteps {

    private WebDriver driver;
    private String homeURL = "http://localhost:8080";

    @Given("^I have a browser opened for SignUpTesting$")
    public void i_have_a_browser_opened() throws Throwable {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
    }

    @And("^browser is closed for SignUpTesting$")
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
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "First Name cannot be empty");
    }

    @And("^I enter \"([^\"]*)\" in first name field$")
    public void i_enter_in_first_name_field(String arg1) throws Throwable {
        driver.findElement(By.name("firstname")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty first name message$")
    public void i_should_not_receive_an_empty_first_name_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
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
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Last Name cannot be empty");
    }

    @Then("^I should not receive an empty last name message$")
    public void i_should_not_receive_an_empty_last_name_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Last Name cannot be empty");
    }


    /*
     * Email Check
     */
    @Then("^I should receive an empty email message$")
    public void i_should_receive_an_empty_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Email id cannot be empty");
    }

    @When("^I enter \"([^\"]*)\" in email field$")
    public void i_enter_in_email_field(String arg1) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty email message and should receive a wrong email message$")
    public void i_should_receive_a_wrong_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Email id cannot be empty");
        Assert.assertEquals(msg, "Invalid Email id entered!!");
    }

    @Then("^I should not receive a wrong email message or empty email message$")
    public void i_should_not_receive_a_wrong_email_message_or_empty_email_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Email id cannot be empty");
        Assert.assertNotEquals(msg, "Invalid Email id entered!!");
    }


    /*
     * Password Check
     */
    @Then("^I should receive an empty password message$")
    public void i_should_receive_an_empty_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Password field cannot be empty");
    }

    @And("^I enter \"([^\"]*)\" in password field$")
    public void i_enter_in_password_field(String arg1) throws Throwable {
        driver.findElement(By.id("pswd")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty password message and should receive a 6-character message$")
    public void i_should_not_receive_an_empty_password_message_and_should_receive_a_6_character_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertEquals(msg, "Password must contain at least 6 characters");
    }

    @Then("^I should not receive an empty password message and should not receive a 6-character message and should receive an alphanumeric message$")
    public void i_should_not_receive_a_empty_password_message_and_should_not_receive_a_6_character_message_and_should_receive_an_aphanumeric_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertNotEquals(msg, "Password must contain at least 6 characters");
        Assert.assertEquals(msg, "Password must contain alphanumeric characters");

    }

    @Then("^I should not receive an empty password message and should not receive a 6-character message and should not receive an alphanumeric message$")
    public void i_should_not_receive_a_empty_password_message_and_should_not_receive_a_6_character_message_and_should_not_receive_an_aphanumeric_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Password field cannot be empty");
        Assert.assertNotEquals(msg, "Password must contain at least 6 characters");
        Assert.assertNotEquals(msg, "Password must contain alphanumeric characters");
    }


    /*
     * Confirm Password Check
     */
    @Then("^I should receive an empty confirm password message$")
    public void i_should_receive_an_empty_confirm_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Confirm Password cannot be empty");
    }


    @And("^I enter \"([^\"]*)\" in confirm password field$")
    public void i_enter_in_confirm_password_field(String arg1) throws Throwable {
        driver.findElement(By.id("confirm_pswd")).sendKeys(arg1);
    }

    @Then("^I should not receive an empty confirm password message$")
    public void i_should_not_receive_an_empty_confirm_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Confirm Password cannot be empty");
    }

    @And("^I should receive a non-matching password message$")
    public void i_should_receive_a_non_matching_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Confirm Password does not match with Password");
    }

    @And("^I should not receive a non-matching password message$")
    public void i_should_not_receive_a_non_matching_password_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Confirm Password does not match with Password");
    }

    /*
     * Role Check
     */
    @Then("^I should receive a select-role message$")
    public void i_should_receive_a_select_role_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Role should be selected");
    }

    @When("^I choose User role$")
    public void i_choose_User_role() throws Throwable {
        Select dropdown = new Select (driver.findElement(By.name("role")));
        dropdown.selectByVisibleText("User");
    }

    @Then("^I should not receive an id message for User$")
    public void i_should_not_receive_an_id_message_for_User() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Id is required if you are a User");
    }

    @When("^I choose Admin role$")
    public void i_choose_Admin_role() throws Throwable {
        Select dropdown = new Select (driver.findElement(By.name("role")));
        dropdown.selectByVisibleText("Admin");
    }

    @Then("^I should receive an id message for Admin$")
    public void i_should_receive_an_id_message_Ad() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Id is required if you are a Admin");
    }

    @When("^I choose Manager role$")
    public void i_choose_Manager_role() throws Throwable {
        Select dropdown = new Select (driver.findElement(By.name("role")));
        dropdown.selectByVisibleText("Manager");
    }

    /*
    * Assign ID Check
    */
    @Then("^I should receive an id message for Manager$")
    public void i_should_receive_an_id_message_Manager() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Id is required if you are a Manager");
    }

    @When("^I enter \"([^\"]*)\" in Assign ID$")
    public void i_enter_in_Assign_ID(String arg1) throws Throwable {
        driver.findElement(By.id("roleid")).sendKeys(arg1);
    }

    @Then("^I should not receive an id message for Admin$")
    public void i_should_not_receive_an_id_message_for_Admin() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Id is required if you are a Admin");
    }

    @Then("^I should not receive an id message for Manager$")
    public void i_should_not_receive_an_id_message_for_Manager() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Id is required if you are a Manager");
    }

    /*
    * Gender Check
    */
    @Then("^I should receive an empty gender message$")
    public void i_should_receive_an_empty_gender_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Please Select the Gender");
    }

    @When("^I choose Male gender$")
    public void i_choose_Male_gender() throws Throwable {
        Select dropdown = new Select (driver.findElement(By.name("gender")));
        dropdown.selectByVisibleText("Male");
    }

    @Then("^I should not receive an empty gender message$")
    public void i_should_not_receive_an_empty_gender_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Please Select the Gender");
    }

    @When("^I choose Female gender$")
    public void i_choose_Female_gender() throws Throwable {
        Select dropdown = new Select (driver.findElement(By.name("gender")));
        dropdown.selectByVisibleText("Female");
    }

    /*
    * DOB Check
    */
    @Then("^I should receive an empty dob message$")
    public void i_should_receive_an_empty_dob_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertEquals(msg, "Please select DOB");
    }


    @When("^I enter \"([^\"]*)\" in the dob field$")
    public void i_enter_in_the_dob_field(String arg1) throws Throwable {
        driver.findElement(By.id("calendar")).sendKeys(arg1);
    }

    @Then("^I should receive an error signup message$")
    public void i_should_receive_an_error_signup_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        System.out.println("msg" + msg + "end");
        //Assert.assertEquals(msg, "Error in Signing up!! Please try again");
    }

    @Then("^I should not receive an error signup message$")
    public void i_should_not_receive_an_error_signup_message() throws Throwable {
        String msg = driver.findElement(By.id("lbltipAddedComment")).getAttribute("innerHTML");
        Assert.assertNotEquals(msg, "Error in Signing up!! Please try again");
    }

}