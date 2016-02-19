package com.fundamental.proj.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sai on 2/17/16.
 */
@Controller
public class HomeController {
    @RequestMapping
    public String home(){
        return "login";
    }

    @RequestMapping(value = "/forgot_password")
    public String he()
    {
        return "forgot";
    }

    @RequestMapping(value = "/session")
     @ResponseBody
     public String Logined_in() {
        //HYBERNET CALLS
        return "Logged In";
    }
    @RequestMapping(value = "/sign_up")
    public String sign_up(){
        return "signup";
    }
}

