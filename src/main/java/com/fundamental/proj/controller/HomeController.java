package com.fundamental.proj.controller;
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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "WEB-INF/views/login/login";
    }

    @RequestMapping(value = "/forgot_password1", method = RequestMethod.POST)
    @ResponseBody
    public String he()
    {
        return "WEB-INF/views/forgot";
    }
    @RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> Logined(@RequestBody UserBean userBean) {
        //HIBERNETCALLS

        System.out.println(userBean.getEmail());
        List<UserBean> u = userDelegate.getUserList(userBean);
        return u;
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

