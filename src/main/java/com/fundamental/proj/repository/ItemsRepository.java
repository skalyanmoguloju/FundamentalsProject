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
    public List<String> getAllCatgs()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct category from Items");

        return query.list();
    }
    @Transactional
    public List<Items> getAllItemsContainingSearchTerm(String term, String cat)
    {
        if(cat =="All") {
            Session session = sessionFactory.getCurrentSession();
            if (term == "") {
                Query query = session.createQuery("from Items");

                return query.list();
            } else {
                Query query = session.createQuery("FROM Items where item_name LIKE :searchTerm or item_description LIKE :searchTerm") ;
                query.setParameter("searchTerm", term + '%');

                return query.list();
            }
        }
        else
        {
            Session session = sessionFactory.getCurrentSession();
            if (term == "") {
                Query query = session.createQuery("from Items");

                return query.list();
            } else {
                Query query = session.createQuery("FROM Items where item_name LIKE :searchTerm or item_description LIKE :searchTerm and category =:catg");
                query.setParameter("searchTerm", term + '%');
                query.setParameter("catg", cat);
                return query.list();
            }
        }
    }

    @Transactional
    public List<Items> getAllCatItemsContainingSearchTerm(String term)
    {
        Session session = sessionFactory.getCurrentSession();
        if(term.trim().equals("All")) {
            Query query = session.createQuery("from Items");

            return query.list();
        } else {
            Query query = session.createQuery("FROM Items where category = :searchTerm") ;
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

    @Transactional
    public List<Long> updateSoldCount(Items items)
    {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query1 = session.createQuery("update Items set sold_count=:val where item_id=:iid");
            query1.setParameter("iid",items.getItem_id());
            query1.setParameter("val", items.getSold_count());
            query1.executeUpdate();
            session.flush();
            //session.update(items);
            Query query = session.createQuery("select sold_count from Items where item_id=:itemid");
            query.setParameter("itemid", items.getItem_id());
            return query.list();
        }
        catch (Exception e)
        {
            return i;
        }
    }
}

