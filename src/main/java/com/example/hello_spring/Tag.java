package com.example.hello_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "tag", schema = "public")
public class Tag extends User {
    private  String text;

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "text")
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    @ManyToOne
    private Post post;

    @Override
    public String toString() {
        return "Tag{" +
                ", text='" + text + '\'' +
                '}';
    }
}
