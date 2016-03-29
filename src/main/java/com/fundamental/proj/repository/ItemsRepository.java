package com.fundamental.proj.repository;

import com.fundamental.proj.model.Items;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.fundamental.proj.model.Items;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/9/16.
 */
@Repository
@EnableTransactionManagement
public class ItemsRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public List<Items> getAllItems()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Items");

        return query.list();
    }

    @Transactional
    public List<Items> getAllItemsContainingSearchTerm(String term)
    {
        Session session = sessionFactory.getCurrentSession();
        if(term == "") {
            Query query = session.createQuery("from Items");

            return query.list();
        } else {
            Query query = session.createQuery("FROM Items where item_name LIKE :searchTerm or item_description LIKE :searchTerm or category LIKE :searchTerm");
            query.setParameter("searchTerm", term);

            return query.list();
        }
    }

    @Transactional
    public List<Long> addItem(Items items)
    {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(items);
            Query query = session.createQuery("select max(item_id) from Items ");
            query.list();
            session.flush();
            return query.list();
        }
        catch (Exception e)
        {
            return i;
        }
    }
}

