package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.mapper.RolesBeanMapper;
import com.fundamental.proj.model.Roles;
import com.fundamental.proj.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 2/22/16.
 */
@Service
public class RolesDelegate {

    @Autowired
    RolesService rolesService;

    @Transactional
    public List<String> getRolesList(){
        List<String> roles;
        roles = rolesService.getAllRoles();
        return  roles;
    }
}
