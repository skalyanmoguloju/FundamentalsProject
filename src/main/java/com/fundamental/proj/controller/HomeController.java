package com.fundamental.proj.controller;
import com.fundamental.proj.delegate.UserDelegate;
import com.fundamental.proj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fundamental.proj.controller.bean.UserBean;

import java.util.List;

/**
 * Created by sai on 2/17/16.
 */
@Controller
public class HomeController {


    @Autowired
    private UserDelegate userDelegate;


    @RequestMapping
    public String home(){
        return "login";
    }

    @RequestMapping(value = "/forgot_password")
    public String he()
    {
        return "forgot";
    }

    @RequestMapping(value = "/session/{id}/{pswd}")
     @ResponseBody
     public List<UserBean> Logined_in(@PathVariable String id, @PathVariable String pswd) {
        //HIBERNETCALLS

        UserBean userBean = new UserBean();
        userBean.setId(Long.parseLong(id));
        List <UserBean> u = userDelegate.getUserList();
        return u;


    }
    @RequestMapping(value = "/sign_up")
    public String sign_up(){
        return "signup";
    }
}

