package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 2/18/16.
*/
@Component
public class UserBeanMapper {

    public UserBean mapUserBean(User user){
        UserBean userBean = new UserBean();
        userBean.setId(user.getId());
        userBean.setName(user.getName());
        userBean.setDob(user.getDob());
        userBean.setEmail(user.getEmail());
        userBean.setLname(user.getLname());
        userBean.setRole(user.getRole());
        return userBean;
    }

    public User mapBeanToUser(UserBean userBean){
        User user = new User();
        user.setName(userBean.getName());
        user.setId(userBean.getId());
        user.setDob(userBean.getDob());
        user.setEmail(userBean.getEmail());
        user.setLname(userBean.getLname());
        user.setRole(userBean.getRole());
        return user;
    }

    public List<UserBean> mapUserBean(List<User> users)
    {
        List<UserBean> userBeans = new ArrayList<UserBean>();
        for(User user:users){
            userBeans.add((mapUserBean(user)));
        }
        return userBeans;
    }
}
