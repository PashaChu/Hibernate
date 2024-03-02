package com.example.hello_spring.repository;

import com.example.hello_spring.model.Post;
import com.example.hello_spring.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {

    default List<Post> findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        List<Post> posts = (List<Post>)  sessionFactory.openSession().createQuery("From Post", Post.class).list();
        return posts;
    }

    default Post findById(Long id) throws HibernateException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession().get(Post.class, id);
    }

    default Post save(Post post) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.persist(post);
            tx1.commit();

        }
    }

    default void deleteById(Long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.remove(post);
            tx1.commit();
        }
    }
}
