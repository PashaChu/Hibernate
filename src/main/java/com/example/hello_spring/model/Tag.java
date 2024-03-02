package com.example.hello_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tag", schema = "public")
public class Tag extends User {

    private  String name;

    public Tag(){}
    public Tag(String name){
        this.name = name;
    }

    @Column(name = "name")
    public String getText() {return name;}
    public void setText(String text) {this.name = text;}

    @Override
    public String toString() {
        return "Tag{" +
                ", text='" + name  +
                '}';
    }


}
