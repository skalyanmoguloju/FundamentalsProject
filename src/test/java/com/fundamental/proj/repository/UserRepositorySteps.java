package com.fundamental.proj.repository;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Assert;

import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class UserRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private UserRepository userRepository;

    private List<User> expectedListUser;
    private List<Long> expectedListID;
    private List<String> expectedListPswd;

    @Given("^mock UserRepository is initialized$")
    public void mock_userrepository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);
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
            Assert.assertEquals(actualListUser.get(x).getStatus(), expectedListUser.get(x).getStatus());
            Assert.assertEquals(actualListUser.get(x).getRole(), expectedListUser.get(x).getRole());
        }
    }

    private void checkListID(List<Long> actualListID) {
        Assert.assertEquals(actualListID.size(), expectedListID.size());
        for (int x = 0; x < expectedListID.size(); x++)
            Assert.assertEquals(actualListID.get(x), expectedListID.get(x));
    }

    /************************************************/
    /*
     * Test finAllUsers()
     */
    /***********************************************/
    @When("^finAllUsers\\(\\) is called$")
    public void finallusers_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from User where email=:eid and pwsd=:pswd")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("eid"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("pswd"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListUser);
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
        user2.setRole("Manager");
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

    @Then("^a list of users is returned for finAllUsers")
    public void a_list_of_users_is_returned_finAllUsers() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.finAllUsers(userBean);

        checkListUser(actualListUser);

        // verify finAllUsers method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where email=:eid and pwsd=:pswd");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).setParameter("pswd", userBean.getPwsd());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null list of users is initialized$")
    public void expected_null_list_of_users_is_initialized() throws Throwable {
        expectedListUser = null;
    }

    @Then("^a list of users is null for finAllUsers")
    public void a_list_of_users_is_null_finAllUsers() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.finAllUsers(userBean);
        Assert.assertNull(actualListUser);

        // verify finAllUsers method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where email=:eid and pwsd=:pswd");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).setParameter("pswd", userBean.getPwsd());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected empty list of users is initialized$")
    public void expected_empty_list_of_users_is_initialized() throws Throwable {
        expectedListUser = new ArrayList<User>();
    }

    @Then("^a list of users is empty for finAllUsers")
    public void a_list_of_users_is_empty_finAllUsers() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.finAllUsers(userBean);
        Assert.assertEquals(actualListUser.size(), 0);

        // verify finAllUsers method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where email=:eid and pwsd=:pswd");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).setParameter("pswd", userBean.getPwsd());
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test getUserInfo()
     */
    /************************************************/
    @When("^getUserInfo\\(\\) is called$")
    public void getuserinfo_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from User where id=:id")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("id"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListUser);
    }

    @Then("^a list of users is returned for getUserInfo$")
    public void a_list_of_users_is_returned_for_getuserinfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.getUserInfo(userBean);

        checkListUser(actualListUser);

        // verify getUserInfo method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where id=:id");
        Mockito.verify(mockedQuery).setParameter("id", userBean.getId());
        Mockito.verify(mockedQuery).list();
    }

    @Then("^a list of users is null for getUserInfo$")
    public void a_list_of_users_is_null_for_getUserInfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.getUserInfo(userBean);

        Assert.assertNull(actualListUser);

        // verify getUserInfo method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where id=:id");
        Mockito.verify(mockedQuery).setParameter("id", userBean.getId());
        Mockito.verify(mockedQuery).list();
    }

    @Then("^a list of users is empty for getUserInfo$")
    public void a_list_of_users_is_empty_for_getUserInfo() throws Throwable {
        UserBean userBean = new UserBean();
        List<User> actualListUser = userRepository.getUserInfo(userBean);

        Assert.assertEquals(actualListUser.size(), 0);

        // verify getUserInfo method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from User where id=:id");
        Mockito.verify(mockedQuery).setParameter("id", userBean.getId());
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test validateEmail()
     */
    /************************************************/
    @When("^validateEmail\\(\\) is called$")
    public void validateemail_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select id from User where email=:email")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("email"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListID);
    }

    @And("^expected list of ids is initialized for UserRepository")
    public void expected_list_of_ids_is_initialized_ur() throws Throwable {
        expectedListID = new ArrayList<Long>();
        expectedListID.add((long) 1);
        expectedListID.add((long) 2);
        expectedListID.add((long) 3);
    }

    @Then("^a list of ids is returned for validateEmail$")
    public void a_list_of_ids_is_returned_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userRepository.validateEmail(userBean);

        checkListID(actualListID);

        // verify validateEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select id from User where email=:email");
        Mockito.verify(mockedQuery).setParameter("email", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null list of ids is initialized for UserRepository$")
    public void expected_null_list_of_ids_is_initialized_userRepository() throws Throwable {
        expectedListID = null;
    }

    @Then("^a list of ids is null for validateEmail$")
    public void a_list_of_ids_is_null_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userRepository.validateEmail(userBean);

        Assert.assertNull(actualListID);

        // verify validateEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select id from User where email=:email");
        Mockito.verify(mockedQuery).setParameter("email", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected empty list of ids is initialized for UserRepository$")
    public void expected_empty_list_of_ids_is_initialized_ur() throws Throwable {
        expectedListID = new ArrayList<Long>();
    }

    @Then("^a list of ids is empty for validateEmail$")
    public void a_list_of_ids_is_empty_for_validateEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<Long> actualListID = userRepository.validateEmail(userBean);

        Assert.assertEquals(actualListID.size(), 0);

        // verify validateEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select id from User where email=:email");
        Mockito.verify(mockedQuery).setParameter("email", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test addUser()
     */
    /************************************************/
    @When("^addUser\\(\\) is called with user role$")
    public void adduser_is_called_with_user_role() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).persist(User.class);
        Mockito.when(mockedSession.createQuery("select max(id) from User")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListID);
        Mockito.doNothing().when(mockedSession).flush();
        Mockito.when(mockedQuery.list()).thenReturn(expectedListID);
    }

    @Then("^a list of ids is returned for addUser$")
    public void a_list_of_ids_is_returned_for_addUser() throws Throwable {
        User user = new User();
        user.setRole("User");
        List<Long> actualListIDs = userRepository.addUser(user);

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());
        for (int x=0; x<expectedListID.size(); x++)
            Assert.assertEquals(expectedListID.get(x), actualListIDs.get(x));

        // verify addUser method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).persist(user);
        Mockito.verify(mockedSession).createQuery("select max(id) from User");
        Mockito.verify(mockedQuery, Mockito.atLeast(2)).list();
        Mockito.verify(mockedSession).flush();
    }

    @When("^addUser\\(\\) is called with not user role$")
    public void adduser_is_called_with_not_user_role() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).update(User.class);
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^a list of ids is returned with (\\d+) id for addUser$")
    public void a_list_of_ids_is_returned_with_id_for_addUser(int arg1) throws Throwable {
        Long id = 100L;
        User user = new User();
        user.setRole("Manager");
        user.setId(id);
        List<Long> actualListIDs = userRepository.addUser(user);

        Assert.assertEquals(actualListIDs.size(), arg1);
        Assert.assertEquals(actualListIDs.get(0), id);

        // verify addUser method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).update(user);
        Mockito.verify(mockedSession).flush();
    }

    @When("^addUser\\(\\) is called with Exception$")
    public void adduser_is_called_with_exception() throws Throwable {
        BDDMockito.given(mockedSessionFactory.getCurrentSession()).willThrow(Exception.class);
    }

    @Then("^a list of ids is empty for addUser$")
    @Test(expected=Exception.class)
    public void a_list_of_ids_is_empty_for_addUser() throws Throwable {
        Long id = 100L;
        User user = new User();
        user.setRole("Manager");
        user.setId(id);
        List<Long> actualListIDs = userRepository.addUser(user);

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());

        // verify addUser method has been called
        Mockito.verify(mockedSessionFactory).getCurrentSession();
    }

    /************************************************/
    /*
     * Test verifyUser()
     */
    /************************************************/
    @When("^verifyUser\\(\\) is called$")
    public void verifyuser_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("update User set status=:sts where id=:id")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("sts"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("id"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.executeUpdate()).thenReturn(0);
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^verifyUser is successfully called$")
    public void verifyuser_is_successfully_called() throws Throwable {
        Long id = 1L;
        userRepository.verifyUser(id);

        // verify verifyUser method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("update User set status=:sts where id=:id");
        Mockito.verify(mockedQuery).setParameter("sts", "Active");
        Mockito.verify(mockedQuery).setParameter("id", id);
        Mockito.verify(mockedQuery).executeUpdate();
        Mockito.verify(mockedSession).flush();
    }

    /************************************************/
    /*
     * Test resetPswd()
     */
    /************************************************/
    @When("^resetPswd\\(\\) is called$")
    public void resetpswd_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("update User set password=:pswd where id=:id")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("pswd"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("id"), Mockito.anyLong())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockedSession).flush();
    }

    @Then("^resetPswd is successfully called$")
    public void resetpswd_is_successfully_called() throws Throwable {
        Long id = 1L;
        String pswd = "password";

        userRepository.resetPswd(id, pswd);

        // verify resetPswd method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("update User set password=:pswd where id=:id");
        Mockito.verify(mockedQuery).setParameter("pswd", pswd);
        Mockito.verify(mockedQuery).setParameter("id", id);
        Mockito.verify(mockedQuery).executeUpdate();
        Mockito.verify(mockedSession).flush();
    }

    /************************************************/
    /*
     * Test getPswdInfoWithEmail()
     */
    /************************************************/
    @When("^getPswdInfoWithEmail\\(\\) is called$")
    public void getpswdinfowithemail_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select pwsd from User where email=:eid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("eid"), Mockito.anyString())).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListPswd);
    }

    @And("^expected list of passwords is initialized$")
    public void expected_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = new ArrayList<String>();
        expectedListPswd.add("password1");
        expectedListPswd.add("12345asbv");
        expectedListPswd.add("cbvcs23");
    }

    @Then("^a list of passwords is returned for getPswdInfoWithEmail")
    public void a_list_of_passwords_is_returned_for_getPswdInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userRepository.getPswdInfoWithEmail(userBean);

        Assert.assertEquals(actualListPswd.size(), expectedListPswd.size());
        for (int x=0; x<expectedListPswd.size(); x++)
            Assert.assertEquals(actualListPswd.get(x), expectedListPswd.get(x));

        // verify getPswdInfoWithEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select pwsd from User where email=:eid");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null list of passwords is initialized$")
    public void expected_null_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = null;
    }

    @Then("^a list of passwords is null for getPswdInfoWithEmail")
    public void a_list_of_passwords_is_null_for_getPswdInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userRepository.getPswdInfoWithEmail(userBean);

        Assert.assertNull(actualListPswd);

        // verify getPswdInfoWithEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select pwsd from User where email=:eid");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected empty list of passwords is initialized$")
    public void expected_empty_list_of_passwords_is_initialized() throws Throwable {
        expectedListPswd = new ArrayList<String>();
    }

    @Then("^a list of passwords is empty for getPswdInfoWithEmail")
    public void a_list_of_passwords_is_empty_for_getPswdInfoWithEmail() throws Throwable {
        UserBean userBean = new UserBean();
        List<String> actualListPswd = userRepository.getPswdInfoWithEmail(userBean);

        Assert.assertEquals(actualListPswd.size(), 0);

        // verify getPswdInfoWithEmail method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select pwsd from User where email=:eid");
        Mockito.verify(mockedQuery).setParameter("eid", userBean.getEmail());
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test addNewAdmin()
     */
    /************************************************/

    @When("^addNewAdmin\\(\\) is called for UserRepository$")
    public void addnewadmin_is_called_for_UserRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select max(id) from User where role=:rolename")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("rolename"), Mockito.eq("Admin"))).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListID);
    }

    @Then("^a list of ids is returned for addNewAdmin$")
    public void a_list_of_ids_is_returned_for_addNewAdmin() throws Throwable {
        List<Long> actualListIDs = userRepository.addNewAdmin();

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());
        for (int x=0; x<expectedListID.size(); x++)
            Assert.assertEquals(expectedListID.get(x), actualListIDs.get(x));

        // verify addNewAdmin method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select max(id) from User where role=:rolename");
        Mockito.verify(mockedQuery).setParameter("rolename", "Admin");
        Mockito.verify(mockedQuery).list();
    }

    @When("^addNewAdmin\\(\\) is called with Exception for UserRepository$")
    public void addnewadmin_is_called_with_Exception_for_UserRepository() throws Throwable {
        BDDMockito.given(mockedSessionFactory.getCurrentSession()).willThrow(Exception.class);
    }

    @Then("^a list of ids is empty for UserRepository$")
    @Test(expected=Exception.class)
    public void a_list_of_ids_is_empty_for_UserRepository() throws Throwable {
        List<Long> actualListIDs = userRepository.addNewAdmin();

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());

        // verify addNewAdmin method has been called
        Mockito.verify(mockedSessionFactory).getCurrentSession();
    }

    /************************************************/
    /*
     * Test addNewManager()
     */
    /************************************************/
    @When("^addNewManager\\(\\) is called for UserRepository$")
    public void addnewmanager_is_called_for_UserRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select max(id) from User where role=:rolename")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.setParameter(Mockito.eq("rolename"), Mockito.eq("Manager"))).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListID);
    }

    @Then("^a list of ids is returned for addNewManager in UserRepository$")
    public void a_list_of_ids_is_returned_for_addNewManager_in_UserRepository() throws Throwable {
        List<Long> actualListIDs = userRepository.addNewManager();

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());
        for (int x=0; x<expectedListID.size(); x++)
            Assert.assertEquals(expectedListID.get(x), actualListIDs.get(x));

        // verify addNewManager method has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select max(id) from User where role=:rolename");
        Mockito.verify(mockedQuery).setParameter("rolename", "Manager");
        Mockito.verify(mockedQuery).list();
    }

    @When("^addNewManager\\(\\) is called with Exception for UserRepository$")
    public void addnewmanager_is_called_with_Exception_for_UserRepository() throws Throwable {
        BDDMockito.given(mockedSessionFactory.getCurrentSession()).willThrow(Exception.class);
    }

    @Then("^a list of ids is empty for addNewManager in UserRepository$")
    @Test(expected=Exception.class)
    public void a_list_of_ids_is_empty_for_addNewManager_in_UserRepository() throws Throwable {
        List<Long> actualListIDs = userRepository.addNewManager();

        Assert.assertEquals(actualListIDs.size(), expectedListID.size());

        // verify addNewManager method has been called
        Mockito.verify(mockedSessionFactory).getCurrentSession();
    }

}
