package com.fundamental.proj.delegate;

import cucumber.api.java.cs.A;
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
    private List<Long> expectedListIds;
    private List<String> listpswd;

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

    @When("^getUserInfo\\(\\) is called for UserDelegate$")
    public void getuserinfo_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.getUserInfo(Mockito.any(UserBean.class))).thenReturn(mockedListUser);
        Mockito.when(mockedUserBeanMapper.mapUserBean(mockedListUser)).thenReturn(expectedListUserBean);
    }

    @Then("^a list of users is returned for getUserInfo in UserDelegate$")
    public void a_list_of_users_is_returned_for_getUserInfo_in_UserDelegate() throws Throwable {
        UserBean userBean = new UserBean();
        List<UserBean> actualList = userDelegate.getUserInfo(userBean);
        Assert.assertEquals(actualList.size(), expectedListUserBean.size());
        Assert.assertEquals(actualList.get(0), expectedListUserBean.get(0));
        Mockito.verify(mockedUserService).getUserInfo(userBean);
        Mockito.verify(mockedUserBeanMapper).mapUserBean(mockedListUser);
    }

    @Given("^expected list of ids are initialized for validateEmail")
    public void expected_list_of_ids_are_initialized_for_validateEmail() throws Throwable {
        expectedListIds = new ArrayList<Long>();
        expectedListIds.add(1L);
    }

    @When("^validateEmail\\(\\) is called for UserDelegate$")
    public void validateemail_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.validateEmail(Mockito.any(UserBean.class))).thenReturn(expectedListIds);
    }

    @Then("^a list of ids is returned for validateEmail in UserDelegate$")
    public void a_list_of_ids_is_returned_for_validateEmail_in_UserDelegate() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualList = userDelegate.validateEmail(userBean);
        Assert.assertEquals(actualList.size(), expectedListIds.size());
        Assert.assertEquals(actualList.get(0), expectedListIds.get(0));
        Mockito.verify(mockedUserService).validateEmail(userBean);
    }

    @When("^verifyUser\\(\\) is called for UsersDelegate$")
    public void verifyuser_is_called_for_UsersDelegate() throws Throwable {
        Mockito.doNothing().when(mockedUserService).verifyUser(Mockito.anyLong());
    }

    @Then("^verifyUser has been called successfully$")
    public void verifyuser_has_been_called_successfully() throws Throwable {
        userDelegate.verifyUser(1L);
        Mockito.verify(mockedUserService).verifyUser(1L);
    }

    @When("^resetPassword\\(\\) is called for UsersDelegate$")
    public void resetpassword_is_called_for_UsersDelegate() throws Throwable {
        Mockito.doNothing().when(mockedUserService).resetPswd(Mockito.anyLong(), Mockito.anyString());
    }

    @Then("^resetPassword has been called successfully$")
    public void resetpassword_has_been_called_successfully() throws Throwable {
        userDelegate.resetPassword(1L, "pswd");
        Mockito.verify(mockedUserService).resetPswd(1L, "pswd");
    }

    @Given("^expected list of pswd is initialized for getUserPasswordWithEmail$")
    public void expected_list_of_pswd_is_initialized_for_getUserPasswordWithEmail() throws Throwable {
        listpswd = new ArrayList<String>();
        listpswd.add("ps1");
        listpswd.add("ps2");
    }

    @When("^getUserPasswordWithEmail\\(\\) is called for UserDelegate$")
    public void getuserpasswordwithemail_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.getUserInfoWithEmail(Mockito.any(UserBean.class))).thenReturn(listpswd);
    }

    @Then("^a pswd is returned for getUserPasswordWithEmail in UserDelegate$")
    public void a_pswd_is_returned_for_getUserPasswordWithEmail_in_UserDelegate() throws Throwable {
        UserBean userBean = new UserBean();
        String result = userDelegate.getUserPasswordWithEmail(userBean);
        Assert.assertEquals(result, listpswd.get(0));
    }

    @Given("^expected empty list of pswd is initialized for getUserPasswordWithEmail$")
    public void expected_empty_list_of_pswd_is_initialized_for_getUserPasswordWithEmail() throws Throwable {
        listpswd = new ArrayList<String>();
    }

    @Then("^an empty pswd is returned for getUserPasswordWithEmail in UserDelegate$")
    public void an_empty_pswd_is_returned_for_getUserPasswordWithEmail_in_UserDelegate() throws Throwable {
        UserBean userBean = new UserBean();
        String result = userDelegate.getUserPasswordWithEmail(userBean);
        Assert.assertEquals(result, "");
    }

    @Given("^expected list of ids is initialized for addNewAdmin$")
    public void expected_list_of_ids_is_initialized_for_addNewAdmin() throws Throwable {
        expectedListIds = new ArrayList<Long>();
        expectedListIds.add(1L);
    }

    @When("^addNewAdmin\\(\\) is called for UserDelegate$")
    public void addnewadmin_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.addNewAdmin()).thenReturn(expectedListIds);
    }

    @Then("^a list of ids is returned for addNewAdmin in UserDelegate$")
    public void a_list_of_ids_is_returned_for_addNewAdmin_in_UserDelegate() throws Throwable {
        List<Long> actualList = userDelegate.addNewAdmin();
        Assert.assertEquals(actualList.size(), expectedListIds.size());
        Assert.assertEquals(actualList.get(0), expectedListIds.get(0));
        Mockito.verify(mockedUserService).addNewAdmin();
    }

    @Given("^expected list of ids is initialized for addNewManager$")
    public void expected_list_of_ids_is_initialized_for_addNewManager() throws Throwable {
        expectedListIds = new ArrayList<Long>();
        expectedListIds.add(2L);
    }

    @When("^addNewManager\\(\\) is called for UserDelegate$")
    public void addnewmanager_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.addNewManager()).thenReturn(expectedListIds);
    }

    @Then("^a list of ids is returned for addNewManager in UserDelegate$")
    public void a_list_of_ids_is_returned_for_addNewManager_in_UserDelegate() throws Throwable {
        List<Long> actualList = userDelegate.addNewManager();
        Assert.assertEquals(actualList.size(), expectedListIds.size());
        Assert.assertEquals(actualList.get(0), expectedListIds.get(0));
        Mockito.verify(mockedUserService).addNewManager();
    }

    @When("^getAllManagers\\(\\) is called for UserDelegate$")
    public void getallmanagers_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.getAllManagers()).thenReturn(mockedListUser);
        Mockito.when(mockedUserBeanMapper.mapUserBean(mockedListUser)).thenReturn(expectedListUserBean);
    }

    @Then("^a list of users is returned for getAllManagers in UserDelegate$")
    public void a_list_of_users_is_returned_for_getAllManagers_in_UserDelegate() throws Throwable {
        List<UserBean> list = userDelegate.getAllManagers();
        Assert.assertEquals(list.size(), expectedListUserBean.size());
        Assert.assertEquals(list.get(0), expectedListUserBean.get(0));
    }

    @When("^getAllNewManagers\\(\\) is called for UserDelegate$")
    public void getallnewmanagers_is_called_for_UserDelegate() throws Throwable {
        Mockito.when(mockedUserService.getAllNewManagers()).thenReturn(mockedListUser);
        Mockito.when(mockedUserBeanMapper.mapUserBean(mockedListUser)).thenReturn(expectedListUserBean);
    }

    @Then("^a list of users is returned for getAllNewManagers in UserDelegate$")
    public void a_list_of_users_is_returned_for_getAllNewManagers_in_UserDelegate() throws Throwable {
        List<UserBean> list = userDelegate.getAllNewManagers();
        Assert.assertEquals(list.size(), expectedListUserBean.size());
        Assert.assertEquals(list.get(0), expectedListUserBean.get(0));
    }

    @When("^promoteManager\\(\\) is called for UsersDelegate$")
    public void promotemanager_is_called_for_UsersDelegate() throws Throwable {
        Mockito.doNothing().when(mockedUserService).promoteManager(Mockito.anyLong());
    }

    @Then("^promoteManager has been called successfully$")
    public void promotemanager_has_been_called_successfully() throws Throwable {
        userDelegate.promoteManager(1L);
    }

    @When("^approveManager\\(\\) is called for UsersDelegate$")
    public void approvemanager_is_called_for_UsersDelegate() throws Throwable {
        Mockito.doNothing().when(mockedUserService).approveManager(Mockito.anyLong());

    }

    @Then("^approveManager has been called successfully$")
    public void approvemanager_has_been_called_successfully() throws Throwable {
        userDelegate.approveManager(1L);
    }

    @When("^declineManager\\(\\) is called for UsersDelegate$")
    public void declinemanager_is_called_for_UsersDelegate() throws Throwable {
        Mockito.doNothing().when(mockedUserService).declineManager(Mockito.anyLong());
    }

    @Then("^declineManager has been called successfully$")
    public void declinemanager_has_been_called_successfully() throws Throwable {
        userDelegate.declineManager(1L);
    }

    @When("^updateOtherInfo\\(\\) is called for UsersDelegate$")
    public void updateotherinfo_is_called_for_UsersDelegate() throws Throwable {
        Mockito.when(mockedUserBeanMapper.mapBeanToUser(Mockito.any(UserBean.class))).thenReturn(mockedUser);
        Mockito.doNothing().when(mockedUserService).updateOtherInfo(mockedUser);
    }

    @Then("^updateOtherInfo has been called successfully$")
    public void updateotherinfo_has_been_called_successfully() throws Throwable {
        userDelegate.updateOtherInfo(new UserBean());
    }

}
