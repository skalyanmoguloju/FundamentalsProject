package com.fundamental.proj.controller.bean;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Madeline on 3/21/16.
 */
public class RolesBeanSteps {

    @Mock
    private RolesBean mockedRolesBean;
    private String role;
    private String rights;

    @InjectMocks
    private RolesBean rolesBean;

    @Given("^mock RolesBean is initialized$")
    public void mock_RolesBean_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedRolesBean);
    }

    @When("^getRole\\(\\) is called$")
    public void getrole_is_called() throws Throwable {
        mockedRolesBean.getRole();
        Mockito.verify(mockedRolesBean).getRole();
    }

    @Then("^a role is returned$")
    public void a_role_is_returned() throws Throwable {
        String actualRole = rolesBean.getRole();

        Assert.assertEquals(actualRole, role);
    }

    @When("^getRights\\(\\) is called$")
    public void getrights_is_called() throws Throwable {
        mockedRolesBean.getRights();
        Mockito.verify(mockedRolesBean).getRights();
    }

    @Then("^rights are returned$")
    public void rights_are_returned() throws Throwable {
        String actualRights = rolesBean.getRights();

        Assert.assertEquals(actualRights, rights);
    }

    @When("^setRights\\(\\) is called$")
    public void setrights_is_called() throws Throwable {
        rolesBean.setRights(rights);
        mockedRolesBean.setRights(rights);
        Mockito.verify(mockedRolesBean).setRights(rights);
    }

    @Then("^setRights\\(\\) is successfully called$")
    public void setrights_is_successfully_called() throws Throwable {
        rights = "Rights";
        mockedRolesBean.setRights(rights);

        // verify setId has been called successfully
        Mockito.verify(mockedRolesBean).setRights(rights);
    }

    @When("^setRole\\(\\) for RolesBean is called$")
    public void setrole_for_RolesBean_is_called() throws Throwable {
        rolesBean.setRole(role);
        mockedRolesBean.setRole(role);
        Mockito.verify(mockedRolesBean).setRole(role);
    }

    @Then("^setRole\\(\\) for RolesBean is successfully called$")
    public void setrole_for_RolesBean_is_successfully_called() throws Throwable {
        role = "Role";
        mockedRolesBean.setRole(role);

        // verify setId has been called successfully
        Mockito.verify(mockedRolesBean).setRole(role);
    }
}
