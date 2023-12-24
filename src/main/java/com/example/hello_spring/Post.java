package com.example.hello_spring;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "post", schema = "public")
public class Post extends User {
    private String text;
    private String title;


    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "text")
    public String getText() {return text;}
    public void setText(String text){this.text = text;}

    @Column(name = "title")
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    @ManyToOne
    private User user;

    @OneToMany
    private List<Tag> tag;

    @Override
    public String toString(){
        return "Post{" +
                ", text='" + text + '\'' +
                ", title='" +title + '\'' +
                '}';
    }
}
