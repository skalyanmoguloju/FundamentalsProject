package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Daniel Dao on 3/8/16.
 */
public class UserBeanMapperSteps {

    private UserBeanMapper userBeanMapper;

    private User user;
    private User expectedUser;

    private UserBean userBean;
    private UserBean expectedUserBean;

    private List<User> listUser;
    private List<UserBean> listUserBean;

    /************************************************/
    /*
     * Test mapUserBean()
     */
    /***********************************************/
    @Given("^UserBeanMapper is initialized$")
    public void userbeanmapper_is_initialized() throws Throwable {
        userBeanMapper = new UserBeanMapper();
    }

    @When("^mapUserBean is called for UserBeanMapper$")
    public void mapUserBean_is_called_for_UserBeanMapper() throws Throwable {
        user = new User();
        user.setId(1L);
        user.setName("name");
        user.setDob(new Date());
        user.setEmail("email");
        user.setLname("lname");
        user.setRole("role");
        user.setStatus("Status");
        user.setGender("gender");
        user.setPwsd("pswd");

        expectedUserBean = userBeanMapper.mapUserBean(user);
    }

    @Then("^mapUserBean returns a userBean$")
    public void mapuserbean_returns_a_userBean() throws Throwable {
        Assert.assertEquals(expectedUserBean.getId(), user.getId(), 1E-15);
        Assert.assertEquals(expectedUserBean.getName(), user.getName());
        Assert.assertEquals(expectedUserBean.getDob(), user.getDob());
        Assert.assertEquals(expectedUserBean.getEmail(), user.getEmail());
        Assert.assertEquals(expectedUserBean.getLname(), user.getLname());
        Assert.assertEquals(expectedUserBean.getRole(), user.getRole());
        Assert.assertEquals(expectedUserBean.getStatus(), user.getStatus());
        Assert.assertEquals(expectedUserBean.getGender(), user.getGender());
        Assert.assertEquals(expectedUserBean.getPwsd(), user.getPwsd());
    }

    /************************************************/
    /*
     * Test mapBeanToUser()
     */
    /***********************************************/
    @When("^mapBeanToUser is called for UserBeanMapper$")
    public void mapBeanToUser_is_called_for_UserBeanMapper() throws Throwable {
        userBean = new UserBean();
        userBean.setId(1L);
        userBean.setName("name");
        userBean.setDob(new Date());
        userBean.setEmail("email");
        userBean.setLname("lname");
        userBean.setRole("role");
        userBean.setStatus("Status");
        userBean.setGender("gender");
        userBean.setPwsd("pswd");

        expectedUser = userBeanMapper.mapBeanToUser(userBean);
    }

    @Then("^mapBeanToUser returns an user$")
    public void mapbeantouser_returns_an_user() throws Throwable {
        Assert.assertEquals(expectedUser.getId(), userBean.getId(), 1E-15);
        Assert.assertEquals(expectedUser.getName(), userBean.getName());
        Assert.assertEquals(expectedUser.getDob(), userBean.getDob());
        Assert.assertEquals(expectedUser.getEmail(), userBean.getEmail());
        Assert.assertEquals(expectedUser.getLname(), userBean.getLname());
        Assert.assertEquals(expectedUser.getRole(), userBean.getRole());
        Assert.assertEquals(expectedUser.getStatus(), userBean.getStatus());
        Assert.assertEquals(expectedUser.getPwsd(), userBean.getPwsd());
        Assert.assertEquals(expectedUser.getGender(), userBean.getGender());
    }

    /************************************************/
    /*
     * Test mapUserBean()
     */
    /***********************************************/
    @When("^mapUserBeanList is called for UserBeanMapper$")
    public void mapuserbeanlist_is_called_for_UserBeanMapper() throws Throwable {
        listUser = new ArrayList<User>();
        user = new User();
        user.setId(1L);
        user.setName("name");
        user.setDob(new Date());
        user.setEmail("email");
        user.setLname("lname");
        user.setRole("role");
        user.setStatus("Status");
        user.setGender("gender");
        user.setPwsd("pswd");

        listUser.add(user);

        listUserBean = userBeanMapper.mapUserBean(listUser);
    }

    @Then("^mapUserBeanList returns a list of userBeans$")
    public void mapuserbeanlist_returns_a_list_of_userBeans() throws Throwable {
        Assert.assertEquals(listUser.size(), listUserBean.size());

        for (int x=0; x<listUser.size(); x++) {
            Assert.assertEquals(listUser.get(x).getId(), listUserBean.get(x).getId(), 1E-15);
            Assert.assertEquals(listUser.get(x).getName(), listUserBean.get(x).getName());
            Assert.assertEquals(listUser.get(x).getDob(), listUserBean.get(x).getDob());
            Assert.assertEquals(listUser.get(x).getEmail(), listUserBean.get(x).getEmail());
            Assert.assertEquals(listUser.get(x).getLname(), listUserBean.get(x).getLname());
            Assert.assertEquals(listUser.get(x).getRole(), listUserBean.get(x).getRole());
            Assert.assertEquals(listUser.get(x).getStatus(), listUserBean.get(x).getStatus());
            Assert.assertEquals(listUser.get(x).getPwsd(), listUserBean.get(x).getPwsd());
            Assert.assertEquals(listUser.get(x).getGender(), listUserBean.get(x).getGender());
        }
    }

}
