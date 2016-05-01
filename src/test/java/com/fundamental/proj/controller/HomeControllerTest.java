package com.fundamental.proj.controller;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.delegate.RolesDelegate;
import com.fundamental.proj.delegate.UserDelegate;
import com.fundamental.proj.util.EmailNotification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 4/3/16.
 */
public class HomeControllerTest {

    @Mock
    private UserDelegate mockedUserDelegate;

    @Mock
    private RolesDelegate mockedRolesDelegate;

    @Mock
    private BCryptPasswordEncoder mockedBCryptPasswordEncoder;

    @Mock
    private UserBean mockedUserBean;

    @Mock
    EmailNotification mockedEmailVerification;

    @InjectMocks
    private HomeController homeController;

    @Before
    public void setUp() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserDelegate, mockedRolesDelegate, mockedBCryptPasswordEncoder, mockedUserBean, mockedEmailVerification);
    }

    @Test
    public void loginTest() {
        String result = homeController.login();
        Assert.assertEquals(result, "WEB-INF/views/login/login");
    }

    @Test
    public void homeTest() {
        String result = homeController.home();
        Assert.assertEquals(result, "WEB-INF/views/home/home");
    }

    @Test
    public void heTest() {
        String result = homeController.he();
        Assert.assertEquals(result, "WEB-INF/views/forgot");
    }

    @Test
    public void loginedTest() {
        UserBean userBean = new UserBean();
        userBean.setPwsd("test123456");
        List<UserBean> expectedList = new ArrayList<UserBean>();
        expectedList.add(userBean);

        List<UserBean> emptyUserBeanList = homeController.Logined(userBean);
        Assert.assertEquals(emptyUserBeanList.size(), 0);

        Mockito.when(mockedUserDelegate.getUserPasswordWithEmail(Mockito.any(UserBean.class))).thenReturn("$2a$10$XYk2F2XqxemDbBjueYI4G.GNf.QxRMcnvFJ.swhnV.78HYxb85ULO");
        Mockito.when(mockedUserDelegate.getUserList(Mockito.any(UserBean.class))).thenReturn(expectedList);
        List<UserBean> userBeanList = homeController.Logined(userBean);
        Assert.assertEquals(userBeanList.size(), expectedList.size());

        Mockito.verify(mockedUserDelegate, Mockito.atLeastOnce()).getUserPasswordWithEmail(userBean);
        Mockito.verify(mockedUserDelegate).getUserList(userBean);
    }

    @Test
    public void signUpTest() {
        UserBean userBean = new UserBean();
        userBean.setPwsd("test123456");
        List<String> emptyList = homeController.Signup(userBean);
        Assert.assertEquals(emptyList.size(), 0);

        Mockito.when(mockedUserDelegate.getUserPasswordWithEmail(Mockito.any(UserBean.class))).thenReturn("n");
        List<String> actualList = homeController.Signup(userBean);
        Assert.assertEquals(actualList.size(), 1);
        Assert.assertEquals(actualList.get(0), "repeat");

        userBean.setEmail("test@gmail.com");
        userBean.setId(1L);
        List<Long> id = new ArrayList<Long>();
        id.add(1L);
        Mockito.when(mockedUserDelegate.getUserPasswordWithEmail(Mockito.any(UserBean.class))).thenReturn("");
        Mockito.when(mockedUserDelegate.adduser(Mockito.any(UserBean.class))).thenReturn(id);
        actualList = homeController.Signup(userBean);
        Assert.assertEquals(actualList.size(), 3);
        Assert.assertEquals(actualList.get(0), "Done");

        Mockito.verify(mockedUserDelegate, Mockito.atLeastOnce()).getUserPasswordWithEmail(userBean);
        Mockito.verify(mockedUserDelegate).adduser(userBean);
    }

    @Test
    public void sendEmailVerificationTest() {
        UserBean userBean = new UserBean();
        userBean.setId(1L);
        userBean.setEmail("test@gmail.com");

        List<Long> result = homeController.sendEmailVerification(userBean);
        Assert.assertEquals(result.size(), 0);

    }

    @Test
    public void validateEmailTest() {
        UserBean userBean = new UserBean();
        userBean.setEmail("test@gmail.com");
        List<Long> u = new ArrayList<Long>();
        u.add(1L);

        Mockito.when(mockedUserDelegate.validateEmail(userBean)).thenReturn(u);
        List<Long> result = homeController.validateEmail(userBean);
        Assert.assertEquals(result.size(), u.size());
        Assert.assertEquals(result.get(0), u.get(0));

        Mockito.verify(mockedUserDelegate).validateEmail(userBean);
    }

    @Test
    public void userInfoTest() {
        UserBean userBean = new UserBean();

        List<UserBean> u = new ArrayList<UserBean>();
        u.add(new UserBean());

        Mockito.when(mockedUserDelegate.getUserInfo(Mockito.any(UserBean.class))).thenReturn(u);
        List<UserBean> result = homeController.userInfo(userBean);
        Assert.assertEquals(result.size(), u.size());
        Assert.assertEquals(result.get(0), u.get(0));

        Mockito.verify(mockedUserDelegate).getUserInfo(userBean);
    }

    @Test
    public void getRightsTest() {
        RolesBean rolesBean = new RolesBean();

        List<String> s = new ArrayList<String>();
        s.add("test");

        Mockito.when(mockedRolesDelegate.getRights(Mockito.any(RolesBean.class))).thenReturn(s);
        List<String> result = homeController.getRights(rolesBean);
        Assert.assertEquals(result.size(), s.size());
        Assert.assertEquals(result.get(0), s.get(0));

        Mockito.verify(mockedRolesDelegate).getRights(rolesBean);
    }

    @Test
    public void getRolesTest() {
        List<String> s = new ArrayList<String>();
        s.add("test");

        Mockito.when(mockedRolesDelegate.getRolesList()).thenReturn(s);
        List<String> result = homeController.getRoles();
        Assert.assertEquals(result.size(), s.size());
        Assert.assertEquals(result.get(0), s.get(0));

        Mockito.verify(mockedRolesDelegate).getRolesList();
    }

    @Test
    public void Logined_inTest() {
        String id = "1";
        String pswd = "password";
        UserBean userBean = new UserBean();

        List<UserBean> s = new ArrayList<UserBean>();
        s.add(userBean);

        Mockito.doNothing().when(mockedUserBean).setId(Mockito.anyLong());
        Mockito.when(mockedUserDelegate.getUserList(Mockito.any(UserBean.class))).thenReturn(s);
        List<UserBean> result = homeController.Logined_in(id, pswd);
        Assert.assertEquals(result.size(), s.size());
        Assert.assertEquals(result.get(0), s.get(0));
    }

    @Test
    public void sign_upTest() {
        String result = homeController.sign_up();

        Assert.assertEquals(result, "WEB-INF/views/signup");
    }

    @Test
    public void verifyTest() {
        Mockito.doNothing().when(mockedUserDelegate).verifyUser(Mockito.anyLong());
        String result = homeController.verify("1");
        Assert.assertEquals(result, "WEB-INF/views/dummy");
    }

    @Test
    public void pswdResetTest() {
        String result = homeController.pswdReset("1");
        Assert.assertEquals(result, "WEB-INF/views/dummy1");
    }

    @Test
    public void resetTest() {
        String result = homeController.reset();
        Assert.assertEquals(result, "WEB-INF/views/reset");
    }

    @Test
    public void resetDone() {
        UserBean userBean = new UserBean();
        userBean.setPwsd("pswd");
        homeController.idbck = "1";
        List<String> result = homeController.resetDone(userBean);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), "Done");
    }
}
