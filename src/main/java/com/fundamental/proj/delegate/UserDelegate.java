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
    public List<UserBean> getUserList(UserBean userBean){
        List<User> users;
        users = userService.getAllUsers(userBean);
        List<UserBean> userBeans = userBeanMapper.mapUserBean(users);
        return  userBeans;
    }
    @Transactional
    public List<UserBean> getUserInfo(UserBean userBean){
        List<User> users;
        users = userService.getUserInfo(userBean);
        List<UserBean> userBeans = userBeanMapper.mapUserBean(users);
        return  userBeans;
    }
}
