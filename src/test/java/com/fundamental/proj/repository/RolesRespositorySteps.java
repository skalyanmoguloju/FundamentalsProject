package com.fundamental.proj.repository;

import com.fundamental.proj.controller.bean.RolesBean;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

public class RolesRespositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private RolesRepository rolesRepository;

    private List<String> expectedAllRoles;
    private List<String> expectedAllRights;

    @Given("^mock RolesRepository is initialized$")
    public void mock_rolesrepository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);
    }

    /************************************************/
    /*
     * Test getAllRole()
     */
    /***********************************************/
    @And("^expected roles are initialized$")
    public void expected_roles_are_initialized() throws Throwable {
        expectedAllRoles = new ArrayList<String>();
        expectedAllRoles.add("role 1");
        expectedAllRoles.add("role 2");
    }

    @When("^getAllRoles\\(\\) is called$")
    public void getallroles_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select distinct role from Roles")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedAllRoles);
    }

    @Then("^a list of roles is returned$")
    public void a_list_of_roles_is_returned() throws Throwable {
        List<String> actualAllRoles = rolesRepository.getAllRole();

        Assert.assertEquals(expectedAllRoles.size(), actualAllRoles.size());
        for (int x=0; x < expectedAllRoles.size(); x++)
            Assert.assertEquals(expectedAllRoles.get(x), actualAllRoles.get(x));

        // verify getAllRole method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct role from Roles");
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null roles are initialized$")
    public void expected_null_roles_are_initialized() throws Throwable {
        expectedAllRoles = null;
    }

    @Then("^a list of roles is returned as null$")
    public void a_list_of_roles_is_returned_as_null() throws Throwable {
        List<String> actualAllRoles = rolesRepository.getAllRole();

        Assert.assertEquals(actualAllRoles, null);

        // verify getAllRole method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct role from Roles");
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected empty roles are initialized$")
    public void expected_empty_roles_are_initialized() throws Throwable {
        expectedAllRoles = new ArrayList<String>();
    }

    @Then("^a list of roles is empty$")
    public void a_list_of_roles_is_empty() throws Throwable {
        List<String> actualAllRoles = rolesRepository.getAllRole();

        Assert.assertEquals(actualAllRoles.size(), 0);

        // verify getAllRole method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct role from Roles");
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test getAllRights()
     */
    /***********************************************/
    @And("^expected rights are initialized$")
    public void expected_rights_are_initialized() throws Throwable {
        expectedAllRights = new ArrayList<String>();
        expectedAllRights.add("right 1");
        expectedAllRights.add("right 2");
        expectedAllRights.add("right 4");
        expectedAllRights.add("right 7");
        expectedAllRights.add("right 8");

    }

    @When("^getAllRights\\(\\) is called$")
    public void getallrights_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select distinct rights from Roles where role=:role")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("role"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedAllRights);
    }

    @Then("^a list of rights is returned$")
    public void a_list_of_rights_is_returned() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesRepository.getAllRights(rolesBean);

        Assert.assertEquals(expectedAllRights.size(), actualAllRights.size());
        for (int x=0; x < expectedAllRights.size(); x++)
            Assert.assertEquals(expectedAllRights.get(x), actualAllRights.get(x));

        // verify getAllRights method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct rights from Roles where role=:role");
        Mockito.verify(mockedQuery).setParameter("role", rolesBean.getRole());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null rights are initialized$")
    public void expected_null_rights_are_initialized() throws Throwable {
        expectedAllRights = null;
    }

    @Then("^a list of rights is returned as null$")
    public void a_list_of_rights_is_returned_as_null() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesRepository.getAllRights(rolesBean);

        Assert.assertNull(actualAllRights);

        // verify getAllRights method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct rights from Roles where role=:role");
        Mockito.verify(mockedQuery).setParameter("role", rolesBean.getRole());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected empty rights are initialized$")
    public void expected_empty_rights_are_initialized() throws Throwable {
        expectedAllRights = new ArrayList<String>();
    }

    @Then("^a list of rights is empty$")
    public void a_list_of_rights_is_empty() throws Throwable {
        RolesBean rolesBean = new RolesBean();
        List<String> actualAllRights = rolesRepository.getAllRights(rolesBean);

        Assert.assertEquals(actualAllRights.size(), 0);

        // verify getAllRights method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select distinct rights from Roles where role=:role");
        Mockito.verify(mockedQuery).setParameter("role", rolesBean.getRole());
        Mockito.verify(mockedQuery).list();
    }

}
