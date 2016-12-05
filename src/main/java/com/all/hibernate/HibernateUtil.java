package com.all.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 33558 on 20.11.2016.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory ;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }catch (HibernateException ex){
                System.err.println("SessionFactory creation Failed " + ex);
            }
        }
        return sessionFactory;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }

}