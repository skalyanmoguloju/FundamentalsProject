package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.delegate.RolesDelegate;
import com.fundamental.proj.delegate.UserDelegate;
import com.fundamental.proj.util.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import com.fundamental.proj.controller.bean.UserBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        EmailNotification em = new EmailNotification();

        //em.sendEmailPasswordReset("kalyansaim@gmail.com");
        return "WEB-INF/views/login/login";

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
        //HIBERNETCALLs
        String p = userBean.getPwsd();
        //String encryptedPswd = passwordEncoder().encode(userBean.getPwsd());
        //userBean.setPwsd(encryptedPswd);
        String passwordToCompare = userDelegate.getUserPasswordWithEmail(userBean);
        boolean isRight = passwordEncoder().matches(p, passwordToCompare);
        if(isRight) {
            userBean.setPwsd(passwordToCompare);
            List <UserBean> u = userDelegate.getUserList(userBean);
            return u;
        } else {
            return Collections.<UserBean>emptyList();

        }
    }

    @RequestMapping(value = "/signupCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<String> Signup(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            userBean.setStatus("Inactive");
            String p = userBean.getPwsd();
            String passwordToCompare = userDelegate.getUserPasswordWithEmail(userBean);
            if(passwordToCompare.equals(""))
            {
                String encryptedPass = passwordEncoder().encode(p);
                userBean.setPwsd(encryptedPass);
                List<Long> id = userDelegate.adduser(userBean);
                userBean.setId(id.get(0));
                s.add("Done");
                s.add(userBean.getId() + "");
                s.add(userBean.getEmail());
            }
            else{
                s.add("repeat");
            }
            return s;
        }
        catch (Exception e)
        {
            return s;
        }

    }

    @RequestMapping(value = "/emailVerification", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> sendEmailVerification(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        List<Long> u = new ArrayList<Long>();
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.sendEmailVerificationLink(userBean.getEmail(), userBean.getId());
        return u;
    }

    @RequestMapping(value = "/forgotCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> validateEmail(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        System.out.println(userBean.getEmail());
        List<Long> u = userDelegate.validateEmail(userBean);
        if(u.size()>0)
        {
            EmailNotification eVer= new EmailNotification();
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
        EmailNotification em = new EmailNotification();
        //em.sendEmailPasswordReset("kalyansaim@gmail.com");
        return "WEB-INF/views/reset";

    }

    @RequestMapping(value = "/resetDone", method = RequestMethod.POST)
    @ResponseBody
    public List<String> resetDone(@RequestBody UserBean userBean)
    {
        userBean.setPwsd(passwordEncoder().encode(userBean.getPwsd()));
        userDelegate.resetPassword(Long.parseLong(idbck), userBean.getPwsd());
        List<String> s = new ArrayList<String>();
        s.add("Done");
        return s;

    }

}

