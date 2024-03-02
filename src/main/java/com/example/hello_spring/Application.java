package com.example.hello_spring;

import com.example.hello_spring.model.User;
import com.example.hello_spring.service.PostService;
import com.example.hello_spring.service.TagService;
import com.example.hello_spring.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private final PostService postService;
    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public Application(PostService postService, TagService tagService, UserService userService){
        this.tagService = tagService;
        this.postService = postService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public void demo(){
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
