package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.model.Roles;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 2/22/16.
 */
@Component
public class RolesBeanMapper {

    public RolesBean mapRolesBean(Roles roles){
        RolesBean rolesBean = new RolesBean();
        rolesBean.setRight(roles.getRight());
        rolesBean.setName(roles.getName());
        return rolesBean;
    }

    public Roles mapBeanToRoles(RolesBean rolesBean){
        Roles roles = new Roles();
        roles.setName(rolesBean.getName());
        roles.setRight(rolesBean.getRight());
        return roles;
    }

    public List<RolesBean> mapRolesBean(List<Roles> roless)
    {
        List<RolesBean> rolesBeans = new ArrayList<RolesBean>();
        for(Roles roles:roless){
            rolesBeans.add((mapRolesBean(roles)));
        }
        return rolesBeans;
    }
}
