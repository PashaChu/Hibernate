package com.example.hello_spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
