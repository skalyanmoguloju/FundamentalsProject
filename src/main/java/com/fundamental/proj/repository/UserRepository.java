package com.fundamental.proj.repository;

import com.fundamental.proj.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 2/18/16.
 */



@Repository
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class UserRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> findAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        return query.list();
    }
}
