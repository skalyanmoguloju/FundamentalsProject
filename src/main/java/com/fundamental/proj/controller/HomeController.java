package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.delegate.RolesDelegate;
import com.fundamental.proj.delegate.UserDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fundamental.proj.controller.bean.UserBean;

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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){
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
        System.out.println(userBean.getEmail());
        List<UserBean> u = userDelegate.getUserList(userBean);
        return u;
    }
    @RequestMapping(value = "/forgotCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<String> validateEmail(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        System.out.println(userBean.getEmail());
        List<String> u = userDelegate.validateEmail(userBean);
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
}

