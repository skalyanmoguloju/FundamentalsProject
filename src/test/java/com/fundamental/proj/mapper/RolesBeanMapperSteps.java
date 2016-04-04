package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.model.Roles;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class RolesBeanMapperSteps {

    private RolesBeanMapper rolesBeanMapper;

    private RolesBean rolesBean;
    private RolesBean actualRolesBean;

    private Roles roles;
    private Roles actualRoles;

    private List<Roles> listRoles;
    private List<RolesBean> actualListRolesBean;

    /************************************************/
    /*
     * Test mapRolesBean()
     */
    /***********************************************/
    @Given("^RolesBeanMapper is initialized$")
    public void rolesBeanMapper_is_initialized() throws Throwable {
        rolesBeanMapper = new RolesBeanMapper();
    }

    @When("^mapRolesBean is called for RolesBeanMapper$")
    public void maprolesbean_is_called_for_RolesBeanMapper() throws Throwable {
        roles = new Roles();
        roles.setRights("test right");
        roles.setRole("test role");

        actualRolesBean = rolesBeanMapper.mapRolesBean(roles);

    }

    @Then("^mapRolesBean returns a rolesBean$")
    public void maprolesbean_returns_a_rolesBean() throws Throwable {
        Assert.assertEquals(actualRolesBean.getRights(), roles.getRights());
        Assert.assertEquals(actualRolesBean.getRole(), roles.getRole());
    }

    /************************************************/
    /*
     * Test mapBeanToRoles()
     */
    /***********************************************/
    @When("^mapBeanToRoles is called for RolesBeanMapper$")
    public void mapbeantoroles_is_called_for_RolesBeanMapper() throws Throwable {
        rolesBean = new RolesBean();
        rolesBean.setRole("testRole");
        rolesBean.setRights("testRight");

        actualRoles = rolesBeanMapper.mapBeanToRoles(rolesBean);
    }

    @Then("^mapBeanToRoles returns a roles$")
    public void mapbeantoroles_returns_a_roles() throws Throwable {
        Assert.assertEquals(actualRoles.getRights(), rolesBean.getRights());
        Assert.assertEquals(actualRoles.getRole(), rolesBean.getRole());
    }

    /************************************************/
    /*
     * Test mapRolesBean(List)
     */
    /***********************************************/
    @When("^mapRolesBeanList is called for RolesBeanMapper$")
    public void maprolesbeanlist_is_called_for_RolesBeanMapper() throws Throwable {
        roles = new Roles();
        roles.setRights("test right");
        roles.setRole("test role");

        listRoles = new ArrayList<Roles>();
        listRoles.add(roles);

        actualListRolesBean = rolesBeanMapper.mapRolesBean(listRoles);
    }

    @Then("^mapBeanToRolesList returns a list of rolesBean$")
    public void mapbeantoroleslist_returns_a_list_of_rolesBean() throws Throwable {
        Assert.assertEquals(actualListRolesBean.size(), listRoles.size());
        for (int x=0; x<listRoles.size(); x++) {
            Assert.assertEquals(actualListRolesBean.get(x).getRole(), listRoles.get(x).getRole());
            Assert.assertEquals(actualListRolesBean.get(x).getRights(), listRoles.get(x).getRights());
        }
    }
}
