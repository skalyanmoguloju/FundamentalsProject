package com.fundamental.proj.repository;

import com.fundamental.proj.model.Cart;
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
 * Created by sai on 3/14/16.
 */

@Repository
@EnableTransactionManagement
public class CartRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public void updateCart(Cart cart)
    {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(cart);
        }
        catch (Exception e)
        {

        }
    }

    @Transactional
    public List<Cart> getCart(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where user_id=:uid");

        query.setParameter("uid", user_id);

        return query.list();
    }

    @Transactional
    public void ClearCart(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Cart where user_id=:uid");
        query.setParameter("uid",user_id);
        query.executeUpdate();
    }
}
