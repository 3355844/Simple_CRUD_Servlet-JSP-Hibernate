package com.all.dao;

import com.all.hibernate.HibernateUtil;
import com.all.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by user on 21.11.2016.
 */
public class UserDao implements dao {

    public void addUserToDb(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            session.close();
        }


    }

    public User returnById(int idUser) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, idUser);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return user;

    }

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public List getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("from User").list();
        session.getTransaction().commit();
//        session.close();
        return list;
    }

    public User findUserByNameAndCreator(String userName, String createdBy) {
        User user = null;
        List users = getAllUsers();
        for (User user1 : (List<User>) users) {
            if (user1.getUserName().equals(userName) && user1.getCreatedBy().equals(createdBy)) {
                user = user1;
            }
        }
        return user;
    }
}
