package com.fundamental.proj.repository;

import com.fundamental.proj.model.Orders;
import com.fundamental.proj.model.Returns;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 4/16/16.
 */
@Repository
@EnableTransactionManagement
public class ReturnRepository {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    private ItemsRepository itemsRepository;

    @Transactional
    public void updateSaleCount(long item_id, int saleCount)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Items set sold_count=:newQuant where item_id=:iid");
        query.setParameter("iid",item_id);
        query.setParameter("newQuant", saleCount);
        query.executeUpdate();
        session.flush();
    }

    @Transactional
    public void AddNewOrder(Orders orders)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orders);
        session.flush();


    }

    @Transactional
    public void returnRequest(Returns returns)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query1 = session.createQuery("from Orders where order_id=:order_id");
        query1.setParameter("order_id",returns.getOrders().getOrder_id());
        List<Orders> orderses = query1.list();

        Query query = session.createQuery("update Orders set quantity=:newQuant, rejected_quantity=:rejQ where order_id=:iid");
        query.setParameter("iid",returns.getOrders().getOrder_id());
        query.setParameter("newQuant", orderses.get(0).getQuantity()-returns.getReturn_count());
        query.setParameter("rejQ", returns.getReturn_count());
        query.executeUpdate();
        session.flush();
        //session.close();

    }

    @Transactional
    public void AddReturn(Returns returns)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(returns);
        session.flush();

    }

    @Transactional
    public List<Returns> getAllOrders(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Returns where orders.materialIndent.user.id=:uid");
        query.setParameter("uid",user_id);
        return query.list();
    }
    @Transactional
    public List<Orders> getReceivedOrders(long user_id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Returns where orders.items.user_id=:uid");
        query.setParameter("uid",user_id);
        return query.list();
    }
}
