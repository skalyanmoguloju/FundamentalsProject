package com.fundamental.proj.repository;

import com.fundamental.proj.model.Address;
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
import java.util.Calendar;
import java.util.Date;
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
    public List<Long> AddSale(MaterialIndent materialIndent, List<Cart> carts) {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(materialIndent);
            session.flush();
            Calendar c = Calendar.getInstance();
            Date date = new Date();

            for(Cart cart : carts)
            {
                c.setTime(date);
                Orders orders = new Orders();
                orders.setMaterialIndent(materialIndent);
                orders.setItems(cart.getItems());
                orders.setQuantity(cart.getQuantity());
                orders.setStatus("Purchased");
                orders.setType("Original");
                orders.setPurchase_date(date);
                if(cart.getItems().getSize().equals("small"))
                {
                    c.add(Calendar.DATE, 1);
                }
                else if(cart.getItems().getSize().equals("medium"))
                {
                    c.add(Calendar.DATE,2);
                }
                else
                {
                    c.add(Calendar.DATE,3);
                }
                orders.setDelivery_date(c.getTime());
                session.persist(orders);
           }

            Query query = session.createQuery("select max(indent_id) from MaterialIndent");
            return query.list();
        }
        catch (Exception e)
        {
            return i;
        }
    }
}
