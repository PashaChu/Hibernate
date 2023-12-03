package com.example.hello_spring;

import com.example.hello_spring.controller.HibernateUtil;
import com.example.hello_spring.controller.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = new User();
            user.setId(1);
            user.setLogin("Vasya");
            user.setPassword("1234");
            user.setCountry("Russia");
            user.setSex("m");

            session.persist(user);

            user.setId(2);
            user.setLogin("Bob");
            user.setPassword("4321");
            user.setCountry("USA");
            user.setSex("m");

            session.persist(user);

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }

        List<User> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Class<User> user = null;
            Query<User> query = session.createQuery("FROM User", user);
            list = query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }

        if (list != null && !list.isEmpty()){
            for(User user : list){
                System.out.println(user);
            }
        }

        HibernateUtil.shutdown();
    }
}
