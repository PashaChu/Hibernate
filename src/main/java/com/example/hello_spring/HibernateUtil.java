package com.example.hello_spring;

import com.example.hello_spring.model.Post;
import com.example.hello_spring.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

    public User findById(int id) throws HibernateException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().get(User.class, id);
    }

    public void save(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.persist(user);
            tx1.commit();

        }
    }

    public void update(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.merge(user);
            tx1.commit();
        }
    }

    public void delete(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.remove(user);
            tx1.commit();
        }
    }

    public Post findAutoById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().get(Post.class, id);
    }

    public List<User> findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        List<User> users = (List<User>)  sessionFactory.openSession().createQuery("From User").list();
        return users;
    }
