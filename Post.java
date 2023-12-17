package com.example.hello_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    private Integer id;
    private String text;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    public Integer getId(){return id;}
    public void setId(Integer id) {this.id = id;}

    public String getText() {return text;}
    public void setText(String text){this.text = text;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    @Override
    public String toString(){
        return "Post{" +
                "id= " +id +
                ", text='" + text + '\'' +
                ", title='" +title + '\'' +
                '}';
    }
}
