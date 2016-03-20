package com.fundamental.proj.bean;

import com.fundamental.proj.controller.bean.UserBean;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Date;

/**
 * Created by Madeline on 3/19/16.
 */
public class UserBeanSteps {
    @Mock
    private UserBean mockedUserBean;

    @InjectMocks
    private UserBean userBean;
    private long idNum;
    private Date dob;
    private String name;
    private String lname;
    private String gender;
    private String status;
    private String role;
    private String email;
    private String pwsd;

    @Given("^mock UserBean is initialized$")
    public void mock_UserBean_is_initialized() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserBean);
    }

    @When("^setId\\(\\) is called$")
    public void setid_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setId(idNum);
        mockedUserBean.setId(idNum);
        Mockito.verify(mockedUserBean).setId(idNum);
    }

    @When("^getId\\(\\) is called$")
    public void getid_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getId();
        Mockito.verify(mockedUserBean).getId();
    }

    @Then("^an id is returned$")
    public void an_id_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        long actualId = userBean.getId();

        Assert.assertEquals(actualId, idNum);
    }

    @Then("^setId\\(\\) is successfully called$")
    public void setid_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        idNum = 3;
        mockedUserBean.setId(idNum);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setId(idNum);
    }

    @When("^getDob\\(\\) is called$")
    public void getdob_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.getDob();
        mockedUserBean.getDob();
        Mockito.verify(mockedUserBean).getDob();
    }

    @Then("^a date is returned$")
    public void a_date_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Date actualDob = userBean.getDob();

        Assert.assertEquals(actualDob, dob);
    }

    @When("^setDob\\(\\) is called$")
    public void setdob_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setDob(dob);
        mockedUserBean.setDob(dob);
        Mockito.verify(mockedUserBean).setDob(dob);
    }

    @Then("^setDob\\(\\) is successfully called$")
    public void setdob_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dob = new Date();
        mockedUserBean.setDob(dob);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setDob(dob);
    }

    @When("^getEmail\\(\\) is called$")
    public void getemail_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getEmail();
        Mockito.verify(mockedUserBean).getEmail();
    }

    @When("^setEmail\\(\\) is called$")
    public void setemail_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setEmail(email);
        mockedUserBean.setEmail(email);
        Mockito.verify(mockedUserBean).setEmail(email);
    }

    @Then("^setEmail\\(\\) is successfully called$")
    public void setemail_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        email = "mail@mail.com";
        mockedUserBean.setEmail(email);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setEmail(email);
    }

    @When("^getLname\\(\\) is called$")
    public void getlname_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getLname();
        Mockito.verify(mockedUserBean).getLname();
    }

    @When("^setLname\\(\\) is called$")
    public void setlname_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setLname(lname);
        mockedUserBean.setLname(lname);
        Mockito.verify(mockedUserBean).setLname(lname);
    }

    @Then("^setLname\\(\\) is successfully called$")
    public void setlname_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        lname = "Last";
        mockedUserBean.setLname(lname);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setLname(lname);
    }

    @When("^getPwsd\\(\\) is called$")
    public void getpwsd_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getPwsd();
        Mockito.verify(mockedUserBean).getPwsd();
    }

    @When("^setPwsd\\(\\) is called$")
    public void setpwsd_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setPwsd(pwsd);
        mockedUserBean.setPwsd(pwsd);
        Mockito.verify(mockedUserBean).setPwsd(pwsd);
    }

    @Then("^setPwsd\\(\\) is successfully called$")
    public void setpwsd_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pwsd = "password";
        mockedUserBean.setPwsd(pwsd);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setPwsd(pwsd);
    }

    @When("^getName\\(\\) is called$")
    public void getname_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getName();
        Mockito.verify(mockedUserBean).getName();
    }

    @When("^setName\\(\\) is called$")
    public void setname_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setName(name);
        mockedUserBean.setName(name);
        Mockito.verify(mockedUserBean).setName(name);
    }

    @Then("^setName\\(\\) is successfully called$")
    public void setname_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        name = "Name";
        mockedUserBean.setName(name);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setName(name);
    }

    @When("^getRole is called$")
    public void getrole_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getRole();
        Mockito.verify(mockedUserBean).getRole();
    }

    @When("^setRole\\(\\) is called$")
    public void setrole_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setRole(role);
        mockedUserBean.setRole(role);
        Mockito.verify(mockedUserBean).setRole(role);
    }

    @Then("^setRole\\(\\) is successfully called$")
    public void setrole_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        role = "User";
        mockedUserBean.setRole(role);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setRole(role);
    }

    @When("^getStatus\\(\\) is called$")
    public void getstatus_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getStatus();
        Mockito.verify(mockedUserBean).getStatus();
    }

    @When("^setStatus\\(\\) is called$")
    public void setstatus_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setStatus(status);
        mockedUserBean.setStatus(status);
        Mockito.verify(mockedUserBean).setStatus(status);
    }

    @Then("^setStatus\\(\\) is successfully called$")
    public void setstatus_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        status = "Inactive";
        mockedUserBean.setStatus(status);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setStatus(status);
    }

    @When("^getGender\\(\\) is called$")
    public void getgender_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mockedUserBean.getGender();
        Mockito.verify(mockedUserBean).getGender();
    }

    @When("^setGender\\(\\) is called$")
    public void setgender_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userBean.setGender(gender);
        mockedUserBean.setGender(gender);
        Mockito.verify(mockedUserBean).setGender(gender);
    }

    @Then("^setGender\\(\\) is successfully called$")
    public void setgender_is_successfully_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        gender = "M";
        mockedUserBean.setGender(gender);

        // verify setId has been called successfully
        Mockito.verify(mockedUserBean).setGender(gender);
    }

    @Then("^an email string is returned$")
    public void an_email_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualEmail = userBean.getEmail();

        Assert.assertEquals(actualEmail, email);
    }

    @Then("^a lname string is returned$")
    public void a_lname_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualLname = userBean.getLname();

        Assert.assertEquals(actualLname, lname);
    }

    @Then("^a password string is returned$")
    public void a_password_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualPwsd = userBean.getPwsd();

        Assert.assertEquals(actualPwsd, pwsd);
    }

    @Then("^a name string is returned$")
    public void a_name_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualName = userBean.getName();

        Assert.assertEquals(actualName, name);
    }

    @Then("^a role string is returned$")
    public void a_role_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualRole = userBean.getRole();

        Assert.assertEquals(actualRole, role);
    }

    @Then("^a status string is returned$")
    public void a_status_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualStatus = userBean.getStatus();

        Assert.assertEquals(actualStatus, status);
    }

    @Then("^a gender string is returned$")
    public void a_gender_string_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualGender = userBean.getGender();

        Assert.assertEquals(actualGender, gender);
    }
}
