package com.example.hello_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    private  Integer id;
    private  String text;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId(){return id;}
    public void setId(Integer id) {this.id = id;}

    public String getText(){return text;}
    public void setText(String text){this.text = text;}

    @Override
    public String toString(){
        return "Tag{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
