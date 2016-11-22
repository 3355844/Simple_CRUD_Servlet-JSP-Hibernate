package com.all.dao;

import com.all.hibernate.HibernateUtil;
import com.all.models.User;
import org.hibernate.Session;

import java.util.ArrayList;

/**
 * Created by user on 21.11.2016.
 */
public class UserDao implements dao {

    public void addUserToDb(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User returnById(int idUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, idUser);
        session.getTransaction().commit();
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

    public void deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, new Integer(id));
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public ArrayList<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList list = (ArrayList) session.createQuery("from User ").list();
        session.getTransaction().commit();
//        session.close();
        return list;
    }

    public User findUserByNameAndCreator(String userName, String createdBy) {
        UserDao userDao = new UserDao();
        User user = null;
        ArrayList<User> users = userDao.getAllUsers();
        for (User user1 : users) {
            if (user1.getUsername().equals(userName) && user1.getCreatedBy().equals(createdBy)) {
                user = user1;
            }
        }
        return user;
    }
}
