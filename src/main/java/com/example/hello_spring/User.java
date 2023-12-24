package com.example.hello_spring;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User {
    private Integer id_user;
    private String login;
    private String password;
    private String country;
    private String sex;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id")
    public Integer getId(){return id_user;}
    public void setId(Integer id){this.id_user = id;}

    @Column(name = "Login")
    public String getLogin(){return login;}
    public void setLogin(String login){this.login = login;}

    @Column(name = "Password")
    public String getPassword(){return password;}
    public void setPassword(String password) {this.password = password;}

    @Column(name = "Country")
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    @Column(name = "Sex")
    public String getSex() {return sex;}
    public void setSex(String sex){this.sex = sex;}

    @OneToMany
    private List<Post> post;

    @Override
    public String toString(){
        return "User{" +
                "id=" + id_user +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
