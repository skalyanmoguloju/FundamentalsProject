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
    @Transactional
    public List<Long> validateEmail(UserBean userBean){
        return userService.validateEmail(userBean);
    }

    @Transactional
    public List<Long> adduser(UserBean userBean){
        User user = new User();
        user = userBeanMapper.mapBeanToUser(userBean);
        return userService.addUser(user);
    }

    @Transactional
    public void verifyUser(Long id)
    {
        userService.verifyUser(id);
    }


    @Transactional
    public void resetPassword(Long id, String pswd)
    {
        userService.resetPswd(id,pswd);
    }

    @Transactional
    public String getUserPasswordWithEmail(UserBean userBean) {
        List<String> pswd;
        pswd = userService.getUserInfoWithEmail(userBean);
        if(pswd.size()>0)
            return pswd.get(0);
        else
            return "";
    }

    @Transactional
    public List<Long> addNewAdmin(){
        return userService.addNewAdmin();
    }

    @Transactional
    public List<Long> addNewManager(){
        return userService.addNewManager();
    }

    @Transactional
    public List<UserBean> getAllManagers(){
        List<User> users;
        users = userService.getAllManagers();
        List<UserBean> userBeans = userBeanMapper.mapUserBean(users);
        return  userBeans;
    }

    @Transactional
    public List<UserBean> getAllNewManagers(){
        List<User> users;
        users = userService.getAllNewManagers();
        List<UserBean> userBeans = userBeanMapper.mapUserBean(users);
        return  userBeans;
    }

    @Transactional
    public void promoteManager(long user_id){
        userService.promoteManager(user_id);
    }

    @Transactional
    public void approveManager(long user_id){
        userService.approveManager(user_id);
    }

    @Transactional
    public void declineManager(long user_id){
        userService.declineManager(user_id);
    }

    @Transactional
    public void updateOtherInfo(UserBean userBean){
        User user = userBeanMapper.mapBeanToUser(userBean);
        userService.updateOtherInfo(user);
    }
}

