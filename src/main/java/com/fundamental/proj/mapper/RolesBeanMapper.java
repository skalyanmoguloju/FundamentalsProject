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
        rolesBean.setRights(roles.getRights());
        rolesBean.setRole(roles.getRole());
        return rolesBean;
    }

    public Roles mapBeanToRoles(RolesBean rolesBean){
        Roles roles = new Roles();
        roles.setRole(rolesBean.getRole());
        roles.setRights(rolesBean.getRights());
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
