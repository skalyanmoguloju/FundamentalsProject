package com.fundamental.proj.service;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;
import com.fundamental.proj.repository.UserRepository;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class UserServiceSteps {

    @Mock
    private UserRepository mockedUserRepository;

    @InjectMocks
    private UserService userService;

    private List<User> expectedListUser;
    private List<Long> expectedListID;
    private List<String> expectedListPswd;

    @Given("^mock UserService is initialized$")
    public void mock_userservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserRepository);
    }

    private void checkListUser(List<User> actualListUser) {
        Assert.assertEquals(actualListUser.size(), expectedListUser.size());
        for (int x = 0; x < expectedListUser.size(); x++) {
            Assert.assertEquals(actualListUser.get(x).getDob(), expectedListUser.get(x).getDob());
            Assert.assertEquals(actualListUser.get(x).getEmail(), expectedListUser.get(x).getEmail());
            Assert.assertEquals(actualListUser.get(x).getGender(), expectedListUser.get(x).getGender());
            Assert.assertEquals(actualListUser.get(x).getId(), expectedListUser.get(x).getId());
            Assert.assertEquals(actualListUser.get(x).getName(), expectedListUser.get(x).getName());
            Assert.assertEquals(actualListUser.get(x).getLname(), expectedListUser.get(x).getLname());
            Assert.assertEquals(actualListUser.get(x).getPwsd(), expectedListUser.get(x).getPwsd());
            Assert.assertEquals(actualListUser.get(x).getRole(), expectedListUser.get(x).getRole());
            Assert.assertEquals(actualListUser.get(x).getStatus(), expectedListUser.get(x).getStatus());
        }
    }

    private void checkListID(List<Long> actualListID) {
        Assert.assertEquals(actualListID.size(), expectedListID.size());
        for (int x = 0; x < expectedListID.size(); x++)
            Assert.assertEquals(actualListID.get(x), expectedListID.get(x));
    }

    /************************************************/
    /*
     * Test getAllUsers()
     */
    /***********************************************/
    @When("^getAllUsers\\(\\) is called$")
    public void getallusers_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.finAllUsers(Mockito.any(UserBean.class))).thenReturn(expectedListUser);
    }

    @And("^expected list of users is initialized$")
    public void expected_list_of_users_is_initialized() throws Throwable {
        User user1 = new User();
        user1.setId((long) 1);
        user1.setRole("Admin");
        user1.setPwsd("123456");
        user1.setName("user");
        user1.setLname("number 1");
        user1.setGender("M");
        user1.setDob(new Date());
        user1.setEmail("user1@gmail.com");
        user1.setStatus("Active");

        User user2 = new User();
        user2.setId((long) 2);
        user2.setRole("User");
        user2.setPwsd("abcdef");
        user2.setName("user");
        user2.setLname("number 2");
        user2.setGender("F");
        user2.setDob(new Date());
        user2.setEmail("user2@gmail.com");
        user2.setStatus("Inactive");

        expectedListUser = new ArrayList<User>();
        expectedListUser.add(user1);
        expectedListUser.add(user2);
    }

    @Then("^a list of users is returned for getAllUsers$")
    public void a_list_of_users_is_returned() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getAllUsers(userBean);

        checkListUser(actualListUser);

        // verify finAllUsers method is called
        Mockito.verify(mockedUserRepository).finAllUsers(userBean);
    }

    @And("^expected null list of users is initialized$")
    public void expected_null_list_of_users_is_initialized() throws Throwable {
        expectedListUser = null;
    }

    @Then("^a list of users is null for getAllUsers$")
    public void a_list_of_users_is_null() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getAllUsers(userBean);
        Assert.assertNull(actualListUser);

        // verify finAllUsers method is called
        Mockito.verify(mockedUserRepository).finAllUsers(userBean);
    }

    @And("^expected empty list of users is initialized$")
    public void expected_empty_list_of_users_is_initialized() throws Throwable {
        expectedListUser = new ArrayList<User>();
    }

    @Then("^a list of users is empty for getAllUsers$")
    public void a_list_of_users_is_empty() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getAllUsers(userBean);
        Assert.assertEquals(actualListUser.size(), 0);

        // verify finAllUsers method is called
        Mockito.verify(mockedUserRepository).finAllUsers(userBean);
    }

    /************************************************/
    /*
     * Test getUserInfo()
     */
    /************************************************/
    @When("^getUserInfo\\(\\) is called$")
    public void getuserinfo_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.getUserInfo(Mockito.any(UserBean.class))).thenReturn(expectedListUser);
    }

    @Then("^a list of users is returned for getUserInfo$")
    public void a_list_of_users_is_returned_for_getuserinfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getUserInfo(userBean);

        checkListUser(actualListUser);

        // verify getUserInfo method is called
        Mockito.verify(mockedUserRepository).getUserInfo(userBean);
    }

    @Then("^a list of users is null for getUserInfo$")
    public void a_list_of_users_is_null_for_getUserInfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getUserInfo(userBean);

        Assert.assertNull(actualListUser);

        // verify getUserInfo method is called
        Mockito.verify(mockedUserRepository).getUserInfo(userBean);
    }

    @Then("^a list of users is empty for getUserInfo$")
    public void a_list_of_users_is_empty_for_getUserInfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userService.getUserInfo(userBean);

        Assert.assertEquals(actualListUser.size(), 0);

        // verify getUserInfo method is called
        Mockito.verify(mockedUserRepository).getUserInfo(userBean);
    }

    /************************************************/
    /*
     * Test validateEmail()
     */
    /************************************************/
    @When("^validateEmail\\(\\) is called$")
    public void validateemail_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.validateEmail(Mockito.any(UserBean.class))).thenReturn(expectedListID);
    }

    @And("^expected list of ids is initialized$")
    public void expected_list_of_ids_is_initialized() throws Throwable {
        expectedListID = new ArrayList<Long>();
        expectedListID.add((long) 1);
        expectedListID.add((long) 2);
        expectedListID.add((long) 3);
        expectedListID.add((long) 4);
    }

    @Then("^a list of ids is returned for validateEmail$")
    public void a_list_of_ids_is_returned_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userService.validateEmail(userBean);

        checkListID(actualListID);

        // verify validateEmail method is called
        Mockito.verify(mockedUserRepository).validateEmail(userBean);
    }

    @And("^expected null list of ids is initialized$")
    public void expected_null_list_of_ids_is_initialized() throws Throwable {
        expectedListID = null;
    }

    @Then("^a list of ids is null for validateEmail$")
    public void a_list_of_ids_is_null_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userService.validateEmail(userBean);

        Assert.assertNull(actualListID);

        // verify validateEmail method is called
        Mockito.verify(mockedUserRepository).validateEmail(userBean);
    }

    @And("^expected empty list of ids is initialized$")
    public void expected_empty_list_of_ids_is_initialized() throws Throwable {
        expectedListID = new ArrayList<Long>();
    }

    @Then("^a list of ids is empty for validateEmail$")
    public void a_list_of_ids_is_empty_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userService.validateEmail(userBean);

        Assert.assertEquals(actualListID.size(), 0);

        // verify validateEmail method is called
        Mockito.verify(mockedUserRepository).validateEmail(userBean);
    }

    /************************************************/
    /*
     * Test addUser()
     */
    /************************************************/
    @When("^addUser\\(\\) is called$")
    public void adduser_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.addUser(Mockito.any(User.class))).thenReturn(expectedListID);

    }

    @Then("^a list of ids is returned for addUser$")
    public void a_list_of_ids_is_returned_for_addUser() throws Throwable {
        User user = new User();
        List<Long> actualListID = userService.addUser(user);

        checkListID(actualListID);

        // verify addUser method is called
        Mockito.verify(mockedUserRepository).addUser(user);
    }

    @Then("^a list of ids is null for addUser$")
    public void a_list_of_ids_is_null_for_addUser() throws Throwable {
        User user = new User();
        List<Long> actualListID = userService.addUser(user);

        Assert.assertNull(actualListID);

        // verify addUser method is called
        Mockito.verify(mockedUserRepository).addUser(user);
    }

    @Then("^a list of ids is empty for addUser$")
    public void a_list_of_ids_is_empty_for_addUser() throws Throwable {
        User user = new User();
        List<Long> actualListID = userService.addUser(user);

        Assert.assertEquals(actualListID.size(), 0);

        // verify addUser method is called
        Mockito.verify(mockedUserRepository).addUser(user);
    }

    /************************************************/
    /*
     * Test verifyUser()
     */
    /************************************************/
    @When("^verifyUser\\(\\) is called$")
    public void verifyuser_is_called() throws Throwable {
        Mockito.doNothing().when(mockedUserRepository).verifyUser(Mockito.any(Long.class));
    }

    @Then("^verifyUser is successfully called$")
    public void verifyuser_is_successfully_called() throws Throwable {
        Long id = 1L;
        userService.verifyUser(id);

        // verify verifyUser method is called
        Mockito.verify(mockedUserRepository).verifyUser(id);
    }

    /************************************************/
    /*
     * Test resetPswd()
     */
    /************************************************/
    @When("^resetPswd\\(\\) is called$")
    public void resetpswd_is_called() throws Throwable {
        Mockito.doNothing().when(mockedUserRepository).resetPswd(Mockito.any(Long.class), Mockito.any(String.class));
    }

    @Then("^resetPswd is successfully called$")
    public void resetpswd_is_successfully_called() throws Throwable {
        Long id = 1L;
        String pswd = "password";

        userService.resetPswd(id, pswd);

        // verify resetPswd method is called
        Mockito.verify(mockedUserRepository).resetPswd(id, pswd);
    }

    /************************************************/
    /*
     * Test getUserInfoWithEmail()
     */
    /************************************************/
    @When("^getUserInfoWithEmail\\(\\) is called$")
    public void getuserinfowithemail_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.getPswdInfoWithEmail(Mockito.any(UserBean.class))).thenReturn(expectedListPswd);
    }

    @And("^expected list of passwords is initialized$")
    public void expected_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = new ArrayList<String>();
        expectedListPswd.add("password1");
        expectedListPswd.add("12345asbv");
        expectedListPswd.add("cbvcs23");
    }

    @Then("^a list of passwords is returned for getUserInfoWithEmail$")
    public void a_list_of_passwords_is_returned_for_getUserInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userService.getUserInfoWithEmail(userBean);

        Assert.assertEquals(actualListPswd.size(), expectedListPswd.size());
        for (int x=0; x<expectedListPswd.size(); x++)
            Assert.assertEquals(actualListPswd.get(x), expectedListPswd.get(x));

        // verify getPswdInfoWithEmail method is called
        Mockito.verify(mockedUserRepository).getPswdInfoWithEmail(userBean);
    }

    @And("^expected null list of passwords is initialized$")
    public void expected_null_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = null;
    }

    @Then("^a list of passwords is null for getUserInfoWithEmail$")
    public void a_list_of_passwords_is_null_for_getUserInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userService.getUserInfoWithEmail(userBean);

        Assert.assertNull(actualListPswd);

        // verify getPswdInfoWithEmail method is called
        Mockito.verify(mockedUserRepository).getPswdInfoWithEmail(userBean);
    }

    @And("^expected empty list of passwords is initialized$")
    public void expected_empty_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = new ArrayList<String>();
    }

    @Then("^a list of passwords is empty for getUserInfoWithEmail$")
    public void a_list_of_passwords_is_empty_for_getUserInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userService.getUserInfoWithEmail(userBean);

        Assert.assertEquals(actualListPswd.size(), 0);

        // verify getPswdInfoWithEmail method is called
        Mockito.verify(mockedUserRepository).getPswdInfoWithEmail(userBean);
    }

    /************************************************/
    /*
     * Test addNewAdmin()
     */
    /************************************************/
    @When("^addNewAdmin\\(\\) is called$")
    public void addnewadmin_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.addNewAdmin()).thenReturn(expectedListID);
    }

    @Then("^a list of ids is returned for addNewAdmin$")
    public void a_list_of_ids_is_returned_for_addNewAdmin() throws Throwable {
        List<Long> actualListID = userService.addNewAdmin();

        checkListID(actualListID);

        // verify addNewAdmin method is called
        Mockito.verify(mockedUserRepository).addNewAdmin();
    }

    @Then("^a list of ids is null for addNewAdmin$")
    public void a_list_of_ids_is_null_for_addNewAdmin() throws Throwable {
        List<Long> actualListID = userService.addNewAdmin();

        Assert.assertNull(actualListID);

        // verify addNewAdmin method is called
        Mockito.verify(mockedUserRepository).addNewAdmin();
    }

    @Then("^a list of ids is empty for addNewAdmin$")
    public void a_list_of_ids_is_empty_for_addNewAdmin() throws Throwable {
        List<Long> actualListID = userService.addNewAdmin();

        Assert.assertEquals(actualListID.size(), 0);

        // verify addNewAdmin method is called
        Mockito.verify(mockedUserRepository).addNewAdmin();
    }

    /************************************************/
    /*
     * Test addNewManager()
     */
    /************************************************/
    @When("^addNewManager\\(\\) is called$")
    public void addnewmanager_is_called() throws Throwable {
        Mockito.when(mockedUserRepository.addNewManager()).thenReturn(expectedListID);
    }

    @Then("^a list of ids is returned for addNewManager$")
    public void a_list_of_ids_is_returned_for_addNewManager() throws Throwable {
        List<Long> actualListID = userService.addNewManager();

        checkListID(actualListID);

        // verify addNewManager method is called
        Mockito.verify(mockedUserRepository).addNewManager();
    }

    @Then("^a list of ids is null for addNewManager$")
    public void a_list_of_ids_is_null_for_addNewManager() throws Throwable {
        List<Long> actualListID = userService.addNewManager();

        Assert.assertNull(actualListID);

        // verify addNewManager method is called
        Mockito.verify(mockedUserRepository).addNewManager();
    }

    @Then("^a list of ids is empty for addNewManager$")
    public void a_list_of_ids_is_empty_for_addNewManager() throws Throwable {
        List<Long> actualListID = userService.addNewManager();

        Assert.assertEquals(actualListID.size(), 0);

        // verify addNewManager method is called
        Mockito.verify(mockedUserRepository).addNewManager();
    }
}
