package com.fundamental.proj.repository;

import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
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
 * Created by sai on 4/4/16.
 */
@Repository
@EnableTransactionManagement
public class AddressRepository {


    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public void updateAddress(Address address)
    {
        try {
            List<Address> list = getAddress(address.getUser_id());
            Session session = sessionFactory.getCurrentSession();

            if (list.size() > 0) {
                Query query = session.createQuery("update Address set line1=:line1, line2=:line2, city=:city, state=:state, zip=:zip, phone=:phone where user_id=:id");
                query.setParameter("id", address.getUser_id());
                query.setParameter("line1", address.getLine1());
                query.setParameter("line2", address.getLine2());
                query.setParameter("city", address.getCity());
                query.setParameter("state", address.getState());
                query.setParameter("zip", address.getZip());
                query.setParameter("phone", address.getPhone());
                query.executeUpdate();
                session.flush();
            } else {
                session.persist(address);
            }
        }
        catch (Exception e)
        {

        }
    }

    @Transactional
    public List<Address> getAddress(long user_id)
   {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Address where user_id=:uid");
        query.setParameter("uid", user_id);
        return query.list();
    }

    @Transactional
    public List<Long> addAddress(Address address)
    {
        List<Long> i = new ArrayList<Long>();
        Session session = sessionFactory.getCurrentSession();
        //session.persist(address);
        Query query = session.createQuery("select max(address_Id) from Address");
        query.list();
        session.flush();
        return query.list();

    }
}
