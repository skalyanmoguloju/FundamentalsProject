package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.service.RolesService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class RolesDelegateSteps {

    @Mock
    private RolesService mockedRolesService;

    @InjectMocks
    private RolesDelegate rolesDelegate;

    private List<String> expectedListRoles;
    private List<String> expectedListRights;

    @Given("^mock RolesDelegate is initialized$")
    public void mock_RolesDelegate_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedRolesService);
    }

    /************************************************/
    /*
     * Test getRolesList()
     */
    /***********************************************/
    @And("^expected roles are initialized for getRolesList$")
    public void expected_roles_are_initialized_getRolesList() throws Throwable {
        expectedListRoles = new ArrayList<String>();
        expectedListRoles.add("role 1");
        expectedListRoles.add("role 2");
    }

    @When("^getRolesList\\(\\) is called$")
    public void getRolesList_is_called() throws Throwable {
        Mockito.when(mockedRolesService.getAllRoles()).thenReturn(expectedListRoles);
    }

    @Then("^a list of roles is returned for getRolesList$")
    public void a_list_of_roles_is_returned_getRolesList() throws Throwable {
        List<String> actualListRoles = rolesDelegate.getRolesList();

        Assert.assertEquals(actualListRoles.size(), expectedListRoles.size());
        for (int x=0; x < actualListRoles.size(); x++)
            Assert.assertEquals(expectedListRoles.get(x), actualListRoles.get(x));

        // verify getRolesList method has been called successfully
        Mockito.verify(mockedRolesService).getAllRoles();
    }

    @And("^expected null roles are initialized for getRolesList$")
    public void expected_null_roles_are_initialized_getRolesList() throws Throwable {
        expectedListRoles = null;
    }

    @Then("^a list of roles is returned as null for getRolesList$")
    public void a_list_of_roles_is_returned_as_null_getRolesList() throws Throwable {
        List<String> actualListRoles = rolesDelegate.getRolesList();

        Assert.assertEquals(actualListRoles, null);

        // verify getRolesList method has been called successfully
        Mockito.verify(mockedRolesService).getAllRoles();
    }

    @And("^expected empty roles are initialized for getRolesList$")
    public void expected_empty_roles_are_initialized_getRolesList() throws Throwable {
        expectedListRoles = new ArrayList<String>();
    }

    @Then("^a list of roles is empty for getRolesList$")
    public void a_list_of_roles_is_empty_getRolesList() throws Throwable {
        List<String> actualListRoles = rolesDelegate.getRolesList();

        Assert.assertEquals(actualListRoles.size(), 0);

        // verify getRolesList method has been called successfully
        Mockito.verify(mockedRolesService).getAllRoles();
    }

    /************************************************/
    /*
     * Test getRights()
     */
    /***********************************************/
    @And("^expected list of rights is initialized for getRights")
    public void expected_rights_is_initialized_getRights() throws Throwable {
        expectedListRights = new ArrayList<String>();
        expectedListRights.add("right 1");
        expectedListRights.add("right 2");
    }

    @When("^getRights\\(\\) is called for RolesRepository$")
    public void getrights_is_called_RolesRepository() throws Throwable {
        Mockito.when(mockedRolesService.getAllRights(Mockito.any(RolesBean.class))).thenReturn(expectedListRights);
    }

    @Then("^a list of rights is returned for getRights$")
    public void a_list_of_rights_is_returned_getRights() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualListRights = rolesDelegate.getRights(rolesBean);

        Assert.assertEquals(expectedListRights.size(), actualListRights.size());
        for (int x=0; x < expectedListRights.size(); x++)
            Assert.assertEquals(expectedListRights.get(x), actualListRights.get(x));

        // verify getRights method has been called successfully
        Mockito.verify(mockedRolesService).getAllRights(rolesBean);
    }

    @And("^expected null list of rights is initialized for getRights$")
    public void expected_null_rights_are_initialized_getRights() throws Throwable {
        expectedListRights = null;
    }

    @Then("^a list of rights is returned as null for getRights$")
    public void a_list_of_rights_is_returned_as_null_getRights() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualListRights = rolesDelegate.getRights(rolesBean);

        Assert.assertNull(actualListRights);

        // verify getRights method has been called successfully
        Mockito.verify(mockedRolesService).getAllRights(rolesBean);
    }

    @And("^expected empty list of rights is initialized for getRights$")
    public void expected_empty_rights_are_initialized_getRights() throws Throwable {
        expectedListRights = new ArrayList<String>();
    }

    @Then("^a list of rights is empty for getRights$")
    public void a_list_of_rights_is_empty_getRights() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualListRights = rolesDelegate.getRights(rolesBean);

        Assert.assertEquals(actualListRights.size(), 0);

        // verify getRights method has been called successfully
        Mockito.verify(mockedRolesService).getAllRights(rolesBean);
    }

}
