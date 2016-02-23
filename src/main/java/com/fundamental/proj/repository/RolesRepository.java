package com.fundamental.proj.repository;

import com.fundamental.proj.controller.bean.RolesBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 2/22/16.
 */
@Repository
@EnableTransactionManagement
public class RolesRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public List<String> getAllRole()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct role from Roles");

        return query.list();
    }

    @Transactional
    public List<String> getAllRights(RolesBean rolesBean)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct rights from Roles where role=:role");
        query.setParameter("role", rolesBean.getRole());
        return query.list();
    }
}
