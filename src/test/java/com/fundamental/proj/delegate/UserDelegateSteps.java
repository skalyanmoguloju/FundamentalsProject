package com.fundamental.proj.delegate;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.fundamental.proj.mapper.UserBeanMapper;

import java.util.ArrayList;
import java.util.List;
import com.fundamental.proj.service.UserService;
import com.fundamental.proj.model.User;
import com.fundamental.proj.controller.bean.UserBean;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Date;
import org.junit.Assert;
/**
 * Created by Madeline on 3/26/16.
 */
public class UserDelegateSteps {
    @Mock
    private UserService mockedUserService;

    @Mock
    private UserBeanMapper mockedUserBeanMapper;

    @Mock
    private User mockedUser;

    @Mock
    private UserBean mockedUserBean;

    @Mock
    private List<User> mockedListUser;

    @InjectMocks
    private UserDelegate userDelegate;

    private List<UserBean> expectedListUserBean;
    @Given("^mock UserDelegate is initialized$")
    public void mock_UserDelegate_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserService, mockedUserBeanMapper, mockedUser, mockedListUser);
    }

    @And("^expected users are initialized for getUserList$")
    public void expected_users_are_initialized_for_getUserList() throws Throwable {
        UserBean user1 = new UserBean();
        user1.setGender("M");
        user1.setName("Name");
        user1.setLname("LName");
        user1.setStatus("Active");
        user1.setPwsd("Pass");
        user1.setRole("User");
        user1.setEmail("Email");
        user1.setDob(new Date());
        user1.setId(2);

        userDelegate.adduser(user1);

        expectedListUserBean = new ArrayList<UserBean>();
        expectedListUserBean.add(user1);
    }

    @When("^getUsersList\\(\\) is called$")
    public void getuserslist_is_called() throws Throwable {
        Mockito.when(mockedUserService.getAllUsers(mockedUserBean)).thenReturn(mockedListUser);
        Mockito.when(mockedUserBeanMapper.mapUserBean(mockedListUser)).thenReturn(expectedListUserBean);
    }

    @Then("^a list of users is returned for getUserList$")
    public void a_list_of_users_is_returned_for_getUserList() throws Throwable {
        UserBean user1 = new UserBean();
        user1.setGender("M");
        user1.setName("Name");
        user1.setLname("LName");
        user1.setStatus("Active");
        user1.setPwsd("Pass");
        user1.setRole("User");
        user1.setEmail("Email");
        user1.setDob(new Date());
        user1.setId(2);

        List<UserBean> actualListUserBean = userDelegate.getUserList(user1);

        Assert.assertEquals(actualListUserBean.size(), actualListUserBean.size());
        for (int x=0; x<actualListUserBean.size(); x++) {
            Assert.assertEquals(actualListUserBean.get(x).getDob(), user1.getDob());
            Assert.assertEquals(actualListUserBean.get(x).getGender(), user1.getGender());
            Assert.assertEquals(actualListUserBean.get(x).getEmail(), user1.getEmail());
            Assert.assertEquals(actualListUserBean.get(x).getLname(), user1.getLname());
            Assert.assertEquals(actualListUserBean.get(x).getName(), user1.getName());
            Assert.assertEquals(actualListUserBean.get(x).getRole(), user1.getRole());
            Assert.assertEquals(actualListUserBean.get(x).getStatus(), user1.getStatus());
        }

        // verify getAllItems has been called successfully
//        Mockito.verify(mockedUserService).getAllUsers(mockedUserBean);
//        Mockito.verify(mockedUserBeanMapper).mapUserBean(mockedListUser);
    }

    @Given("^expected null users are initialized for getUsersList$")
    public void expected_null_users_are_initialized_for_getUsersList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        expectedListUserBean = null;
    }

    @Then("^a list of users is returned as null for getUsersList$")
    public void a_list_of_users_is_returned_as_null_for_getUsersList() throws Throwable {
        List<UserBean> actualListUserBean = userDelegate.getUserList(mockedUserBean);

        Assert.assertNull(actualListUserBean);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedUserService).getAllUsers(mockedUserBean);
        Mockito.verify(mockedUserBeanMapper).mapUserBean(mockedListUser);
    }

    @Given("^expected empty users are initialized for getUsersList$")
    public void expected_empty_users_are_initialized_for_getUsersList() throws Throwable {
        expectedListUserBean = new ArrayList<UserBean>();
    }

    @Then("^a list of users is empty for getUsersList$")
    public void a_list_of_users_is_empty_for_getUsersList() throws Throwable {
        List<UserBean> actualListUserBean = userDelegate.getUserList(mockedUserBean);

        Assert.assertEquals(actualListUserBean.size(), 0);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedUserService).getAllUsers(mockedUserBean);
        Mockito.verify(mockedUserBeanMapper).mapUserBean(mockedListUser);
    }

    @When("^addUser\\(\\) is called for UsersDelegate$")
    public void adduser_is_called_for_UsersDelegate() throws Throwable {
        Mockito.when(mockedUserBeanMapper.mapBeanToUser(Mockito.any(UserBean.class))).thenReturn(mockedUser);
    }

    @Then("^addUser has been called successfully$")
    public void adduser_has_been_called_successfully() throws Throwable {
        UserBean userBean = new UserBean();
        userDelegate.adduser(userBean);

        // verify addItem has been called
        Mockito.verify(mockedUserBeanMapper).mapBeanToUser(userBean);
        Mockito.verify(mockedUserService).addUser(mockedUser);
    }
}
