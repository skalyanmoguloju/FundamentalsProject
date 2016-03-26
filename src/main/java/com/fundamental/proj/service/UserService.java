package com.fundamental.proj.service;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.User;
import com.fundamental.proj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Transient;
import java.util.List;

/**
 * Created by sai on 2/18/16.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers(UserBean userBean)
    {
        return userRepository.finAllUsers(userBean);
    }

    @Transactional
    public List<User> getUserInfo(UserBean userBean)
    {
        return userRepository.getUserInfo(userBean);
    }
    @Transactional
    public List<Long> validateEmail(UserBean userBean)
    {
        return userRepository.validateEmail(userBean);
    }
    @Transactional
    public List<Long> addUser(User user)
    {
        return userRepository.addUser(user);
    }

    @Transactional
    public void verifyUser(Long id)
    {
        userRepository.verifyUser(id);
    }

    @Transactional
    public  void resetPswd(Long id, String pswd)
    {
        userRepository.resetPswd(id, pswd);
    }

    @Transactional
    public List<String> getUserInfoWithEmail(UserBean userBean) {
        return userRepository.getPswdInfoWithEmail(userBean); }


}
