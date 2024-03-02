package com.example.hello_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "post", schema = "public")
public class Post extends User {

    private String text;
    private String title;

    public Post(){}
    public Post(String text, String title){
        this.title = title;
        this.text = text;
    }

    @Column(name = "text")
    public String getText() {return text;}
    public void setText(String text){this.text = text;}

    @Column(name = "title")
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    @Override
    public String toString(){
        return "Post{" +
                ", text='" + text +
                ", title='" +title +
                '}';
    }
}
