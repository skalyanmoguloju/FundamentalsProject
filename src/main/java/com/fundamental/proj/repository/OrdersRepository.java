package com.fundamental.proj.repository;

import com.fundamental.proj.model.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/25/16.
 */
@Repository
@EnableTransactionManagement
public class OrdersRepository {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public List<Orders> getAllOrders(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders where materialIndent.user_id=:uid");
        query.setParameter("uid",user_id);
        return query.list();
    }
}
