package com.fundamental.proj.service;
import com.fundamental.proj.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 2/22/16.
 */
@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Transactional
    public List<String> getAllRoles()
    {
        return rolesRepository.getAllRole();
    }
}
