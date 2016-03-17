package com.fundamental.proj.service;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.repository.RolesRepository;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class RolesServiceSteps {

    @Mock
    private RolesRepository mockedRolesRepository;

    @InjectMocks
    private RolesService rolesService;

    private List<String> expectedAllRoles;
    private List<String> expectedAllRights;

    @Given("^mock RolesService is initialized$")
    public void mock_rolesservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedRolesRepository);
    }

    @And("^expected roles are initialized$")
    public void expected_roles_are_initialized() throws Throwable {
        expectedAllRoles = new ArrayList<String>();
        expectedAllRoles.add("role 1");
        expectedAllRoles.add("role 2");
    }

    @When("^getAllRoles\\(\\) is called$")
    public void getallroles_is_called() throws Throwable {
        Mockito.when(mockedRolesRepository.getAllRole()).thenReturn(expectedAllRoles);
    }

    @Then("^a list of roles is returned$")
    public void a_list_of_roles_is_returned() throws Throwable {
        List<String> actualAllRoles = rolesService.getAllRoles();

        Assert.assertEquals(expectedAllRoles.size(), actualAllRoles.size());
        for (int x=0; x < expectedAllRoles.size(); x++)
            Assert.assertEquals(expectedAllRoles.get(x), actualAllRoles.get(x));

        // verify getAllRoles method is called
        Mockito.verify(mockedRolesRepository).getAllRole();
    }

    @And("^expected null roles are initialized$")
    public void expected_null_roles_are_initialized() throws Throwable {
        expectedAllRoles = null;
    }

    @Then("^a list of roles is returned as null$")
    public void a_list_of_roles_is_returned_as_null() throws Throwable {
        List<String> actualAllRoles = rolesService.getAllRoles();

        Assert.assertEquals(actualAllRoles, null);

        // verify getAllRoles method is called
        Mockito.verify(mockedRolesRepository).getAllRole();
    }

    @And("^expected empty roles are initialized$")
    public void expected_empty_roles_are_initialized() throws Throwable {
        expectedAllRoles = new ArrayList<String>();
    }

    @Then("^a list of roles is empty$")
    public void a_list_of_roles_is_empty() throws Throwable {
        List<String> actualAllRoles = rolesService.getAllRoles();

        Assert.assertEquals(actualAllRoles.size(), 0);

        // verify getAllRoles method is called
        Mockito.verify(mockedRolesRepository).getAllRole();
    }

    @And("^expected rights are initialized$")
    public void expected_rights_are_initialized() throws Throwable {
        expectedAllRights = new ArrayList<String>();
        expectedAllRights.add("right 1");
        expectedAllRights.add("right 2");
        expectedAllRights.add("right 3");
    }

    @When("^getAllRights\\(\\) is called$")
    public void getallrights_is_called() throws Throwable {
        Mockito.when(mockedRolesRepository.getAllRights(Mockito.any(RolesBean.class))).thenReturn(expectedAllRights);
    }

    @Then("^a list of rights is returned$")
    public void a_list_of_rights_is_returned() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesService.getAllRights(rolesBean);

        Assert.assertEquals(expectedAllRights.size(), actualAllRights.size());
        for (int x=0; x < expectedAllRights.size(); x++)
            Assert.assertEquals(expectedAllRights.get(x), actualAllRights.get(x));

        // verify getAllRights method is called
        Mockito.verify(mockedRolesRepository).getAllRights(rolesBean);
    }

    @And("^expected null rights are initialized$")
    public void expected_null_rights_are_initialized() throws Throwable {
        expectedAllRights = null;
    }

    @Then("^a list of rights is returned as null$")
    public void a_list_of_rights_is_returned_as_null() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesService.getAllRights(rolesBean);

        Assert.assertEquals(actualAllRights, null);

        // verify getAllRights method is called
        Mockito.verify(mockedRolesRepository).getAllRights(rolesBean);
    }

    @And("^expected empty rights are initialized$")
    public void expected_empty_rights_are_initialized() throws Throwable {
        expectedAllRights = new ArrayList<String>();
    }

    @Then("^a list of rights is empty$")
    public void a_list_of_rights_is_empty() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesService.getAllRights(rolesBean);

        Assert.assertEquals(actualAllRights.size(), 0);

        // verify getAllRights method is called
        Mockito.verify(mockedRolesRepository).getAllRights(rolesBean);
    }

}
