package com.example.hello_spring;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            User user = new User();
            user.setLogin("Vasya");
            user.setPassword("1234");
            user.setCountry("Russia");
            user.setSex("m");
            session.persist(user);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

    }


}
