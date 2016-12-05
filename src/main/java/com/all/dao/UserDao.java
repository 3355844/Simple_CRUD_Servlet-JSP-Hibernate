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

    public UserDao() {
    }

    public void addUserToDb(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public User returnById(int idUser) {
        User user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        user = (User) session.get(User.class, idUser);
        transaction.commit();
        session.close();
        return user;
    }

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public List <User> getAllUsers() {
        List <User> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        list = (List<User>) session.createQuery("from User ").list();
        transaction.commit();
        session.close();
        return list;
    }

    public User findUserByNameAndCreator(String userName, String createdBy) {
        User user = null;
        List <User> users = getAllUsers();
        for (User user1 : users) {
            if (user1.getUserName().equals(userName) && user1.getCreatedBy().equals(createdBy)) {
                user = user1;
            }
        }
        return user;
    }
}