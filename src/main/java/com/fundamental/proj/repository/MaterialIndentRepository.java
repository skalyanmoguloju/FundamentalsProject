package com.fundamental.proj.repository;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/24/16.
 */
@Repository
@EnableTransactionManagement
public class MaterialIndentRepository {
    @Autowired(required = true)
    private SessionFactory sessionFactory;



    @Transactional
    public List<Long> GetIndentID()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select max(indent_id) from MaterialIndent ");
        return query.list();
    }


    @Transactional
    public void AddSale(MaterialIndent materialIndent, List<Cart> carts) {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(materialIndent);
            session.flush();
            List<Long> indent_ids = GetIndentID();
            long id = indent_ids.get(0);
            for(Cart cart : carts)
            {
                Orders orders = new Orders();
                orders.setIndent_id(id);
                orders.setItem_id(cart.getItems().getItem_id());
                orders.setQuantity(cart.getQuantity());
                orders.setStatus("Purchased");
                session.persist(orders);
                session.flush();
            }

        }
        catch (Exception e)
        {

        }
    }
}
