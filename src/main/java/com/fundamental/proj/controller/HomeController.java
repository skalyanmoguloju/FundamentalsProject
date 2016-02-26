package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.delegate.RolesDelegate;
import com.fundamental.proj.delegate.UserDelegate;
import com.fundamental.proj.util.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fundamental.proj.controller.bean.UserBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by sai on 2/17/16.
 */
@Controller
public class HomeController {


    @Autowired
    private UserDelegate userDelegate;

    @Autowired
    private RolesDelegate rolesDelegate;

    public String idbck ="";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){
        EmailVerification em = new EmailVerification();
        //em.sendEmailPasswordReset("kalyansaim@gmail.com");
        return "WEB-INF/views/login/login";

    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "WEB-INF/views/home/home";
    }


    @RequestMapping(value = "/forgot_password")
    public String he()
    {
        return "WEB-INF/views/forgot";
    }


    @RequestMapping(value = "/loginCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> Logined(@RequestBody UserBean userBean) {
       //HIBERNETCALLS
        List<UserBean> u = userDelegate.getUserList(userBean);
        return u;
    }

    @RequestMapping(value = "/signupCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<String> Signup(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            userBean.setStatus("Inactive");
            List<Long> id = userDelegate.adduser(userBean);
            EmailVerification eVerification = new EmailVerification();
            userBean.setId(id.get(0));
            eVerification.sendEmailVerificationLink(userBean.getEmail(),userBean.getId());
            s.add("Done");
            return s;
        }
        catch (Exception e)
        {
            return s;
        }

    }

    @RequestMapping(value = "/forgotCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> validateEmail(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        System.out.println(userBean.getEmail());
        List<Long> u = userDelegate.validateEmail(userBean);
        if(u.size()>0)
        {
            EmailVerification eVer= new EmailVerification();
            eVer.sendEmailPasswordReset(userBean.getEmail(), u.get(0));
        }
        return u;
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> userInfo(@RequestBody UserBean userBean) {
        //HYBERNETCALLS
        List<UserBean> u = userDelegate.getUserInfo(userBean);
        return u;
    }

    @RequestMapping(value="/rights", method = RequestMethod.POST)
    @ResponseBody
    public List<String> getRights(@RequestBody RolesBean rolesBean) {
        //HIBERNETCALLS
        List<String> s = rolesDelegate.getRights(rolesBean);
        return s;
    }

    @RequestMapping(value="roles", method = RequestMethod.POST)
    @ResponseBody
    public List<String> getRoles() {
        //HIBERNETCALLS
        List<String> s = rolesDelegate.getRolesList();
        return s;
    }




    @RequestMapping(value = "/session/{id}/{pswd}")
     @ResponseBody
     public List<UserBean> Logined_in(@PathVariable String id, @PathVariable String pswd) {
        //HIBERNETCALLS

        UserBean userBean = new UserBean();
        userBean.setId(Long.parseLong(id));
        List <UserBean> u = userDelegate.getUserList(userBean);
        return u;


    }
    @RequestMapping(value = "/sign_up")
    public String sign_up(){
        return "WEB-INF/views/signup";
    }

    @RequestMapping(value = "/reg_activation/{id}")
    public String verify(@PathVariable String id)
    {
        userDelegate.verifyUser(Long.parseLong(id));
        return "WEB-INF/views/dummy";
    }

    @RequestMapping(value = "/password_reset/{id}")
    public String pswdReset(@PathVariable String id)
    {
        idbck = id;
        return "WEB-INF/views/dummy1";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String reset(){
        EmailVerification em = new EmailVerification();
        //em.sendEmailPasswordReset("kalyansaim@gmail.com");
        return "WEB-INF/views/reset";

    }

    @RequestMapping(value = "/resetDone", method = RequestMethod.POST)
    @ResponseBody
    public List<String> resetDone(@RequestBody UserBean userBean)
    {
        userDelegate.resetPassword(Long.parseLong(idbck), userBean.getPwsd());
        List<String> s = new ArrayList<String>();
        s.add("Done");
        return s;

    }

}

