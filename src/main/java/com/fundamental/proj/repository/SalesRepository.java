package com.fundamental.proj.repository;

import com.fundamental.proj.model.Sales;
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
 * Created by sai on 3/10/16.
 */

@Repository
@EnableTransactionManagement
public class SalesRepository {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public void AddSale(Sales sales) {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(sales);
            session.flush();
        }
        catch (Exception e)
        {

        }
    }





}
