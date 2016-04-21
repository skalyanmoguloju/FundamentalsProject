package com.fundamental.proj.repository;

import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.User;
import org.hibernate.SessionFactory;
import org.hsqldb.error.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
/**
 * Created by sai on 2/18/16.
 */



@Repository
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class UserRepository {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> finAllUsers(UserBean userBean){
        long id = 1;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email=:eid and pwsd=:pswd");

        query.setParameter("eid", userBean.getEmail());
        query.setParameter("pswd", userBean.getPwsd());

        return query.list();
    }

    @Transactional
    public List<User> getUserInfo(UserBean userBean){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id=:id");
        query.setParameter("id", userBean.getId());

        return query.list();
    }

    @Transactional
    public List<Long> validateEmail(UserBean userBean){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select id from User where email=:email");

        query.setParameter("email", userBean.getEmail());

        return query.list();
   }

    @Transactional
    public List<Long> addUser(User user)
    {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            if(user.getRole().equals("User"))
            {
                session.persist(user);
                Query query = session.createQuery("select max(id) from User");
                query.list();
                session.flush();
                return query.list();
            }
            else {
                session.update(user);
                i.add(user.getId());
                session.flush();
                return i;
            }
        }
        catch (Exception e)
        {
            return i;
        }
    }


    @Transactional
    public void verifyUser(Long id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select role from User where id=:id");
        query.setParameter("id", id);
        List<String> list = query.list();
        session.flush();
        if (list.get(0).equals("Manager")) {
            query = session.createQuery("update User set status=:sts, role=:role where id=:id");
            query.setParameter("sts", "Pending Manager");
            query.setParameter("role", "User");
            query.setParameter("id", id);
            query.executeUpdate();
            session.flush();
        } else {
            query = session.createQuery("update User set status=:sts where id=:id");
            query.setParameter("sts", "Active");
            query.setParameter("id", id);
            query.executeUpdate();
            session.flush();
        }
    }

    @Transactional
    public void resetPswd(Long id, String pswd)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set pwsd=:pswd where id=:id");
        query.setParameter("pswd", pswd);
        query.setParameter("id", id);
        query.executeUpdate();
        session.flush();
    }

    @Transactional
    public List<String> getPswdInfoWithEmail(UserBean userBean) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select pwsd from User where email=:eid");
        query.setParameter("eid", userBean.getEmail());
        return query.list();
    }

    @Transactional
    public List<Long> addNewAdmin()
    {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = new User();
            String role = "Admin";
            user.setRole(role);
            session.persist(user);

            Query query = session.createQuery("select max(id) from User where role=:rolename");
            query.setParameter("rolename", role);
            return query.list();
        }
        catch (Exception e)
        {
            return i;
        }
    }

    @Transactional
    public List<Long> addNewManager()
    {
        List<Long> i = new ArrayList<Long>();
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = new User();
            String role = "Manager";
            user.setRole(role);
            session.persist(user);

            Query query = session.createQuery("select max(id) from User where role=:rolename");
            query.setParameter("rolename", role);
            return query.list();
        }
        catch (Exception e)
        {
            return i;
        }
    }

    @Transactional
    public List<User> getAllManagers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where role=:rolename and status!=:statusname");
        query.setParameter("rolename", "Manager");
        query.setParameter("statusname", "null");
        return query.list();
    }

    @Transactional
    public List<User> getAllNewManagers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where role=:rolename and status=:statusname");
        query.setParameter("rolename", "User");
        query.setParameter("statusname", "Pending Manager");
        return query.list();
    }

    @Transactional
    public void promoteManager(long user_id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set role=:role where id=:id");
        query.setParameter("role", "Admin");
        query.setParameter("id", user_id);
        query.executeUpdate();
        session.flush();
    }

    @Transactional
    public void approveManager(long user_id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set role=:role, status=:status where id=:id");
        query.setParameter("role", "Manager");
        query.setParameter("status", "Active");
        query.setParameter("id", user_id);
        query.executeUpdate();
        session.flush();
    }

    @Transactional
    public void declineManager(long user_id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set role=:role, status=:status where id=:id");
        query.setParameter("role", "User");
        query.setParameter("status", "Active");
        query.setParameter("id", user_id);
        query.executeUpdate();
        session.flush();
    }

    @Transactional
    public void updateOtherInfo(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set name=:name,lname=:lname, email=:email, gender=:gender, dob=:dob where id=:id");
        query.setParameter("id", user.getId());
        query.setParameter("name", user.getName());
        query.setParameter("lname", user.getLname());
        query.setParameter("email", user.getEmail());
        query.setParameter("gender", user.getGender());
        query.setParameter("dob", user.getDob());
        query.executeUpdate();
        session.flush();
    }
}
