package com.fundamental.proj.service;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;
import com.fundamental.proj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import 

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
    public List<String> validateEmail(UserBean userBean)
    {
        return userRepository.validateEmail(userBean);
    }
    @Transactional
    public void addUser(User user)
    {
        userRepository.addUser(user);
    }

}
