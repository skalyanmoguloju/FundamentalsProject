package com.fundamental.proj.repository;

import com.fundamental.proj.model.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
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
    public List<Orders> getOrderById(long orderid)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders where order_id=:oid");
        query.setParameter("oid",orderid);
        return query.list();
    }

    @Transactional
    public List<Orders> getAllOrders(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders where materialIndent.user.id=:uid order by order_id");
        query.setParameter("uid",user_id);
        return query.list();
    }
    @Transactional
    public List<Orders> getReceivedOrders(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders where items.user_id=:uid order by purchase_date");
        query.setParameter("uid",user_id);
        return query.list();
    }
    @Transactional
    public List<Long> getTotalSold(long item_id)
    {
        List<Long> res = new LinkedList<Long>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select sum(quantity) from Orders where items.item_id=:iid");
        query.setParameter("iid",item_id);
        Query query1 = session.createQuery("select sum(rejected_quantity) from Orders where items.item_id=:iid");
        query1.setParameter("iid",item_id);
        res.add((Long)query.list().get(0)+(Long)query1.list().get(0));
        return res;
    }
    @Transactional
    public void udpateOrders(long order_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Date dt = new Date();
        Query query = session.createQuery("update Orders set status=:val, delivery_date=:val2 where order_id=:iid");
        query.setParameter("iid",order_id);
        query.setParameter("val", "Delivered");
        query.setParameter("val2", dt);
        query.executeUpdate();
        session.flush();
    }
}
