package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.mapper.UserBeanMapper;
import com.fundamental.proj.model.User;
import com.fundamental.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 2/18/16.
 */
@Service
public class UserDelegate {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Autowired
    UserService userService;

    @Transactional
    public List<UserBean> getUserList(){
        List<User> users;
        users = userService.getAllUsers();
        List<UserBean> userBeans = userBeanMapper.mapUserBean(users);
        return  userBeans;
    }
}
