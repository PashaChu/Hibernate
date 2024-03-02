package com.example.hello_spring.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId")
    private Long id_user;
    private String login;
    private String password;
    private String country;
    private String sex;

    public User (){}
    public User(String login, String password, String country, String sex) {
        this.login = login;
        this.password = password;
        this.country = country;
        this.sex = sex;
    }

    @Column(name = "Id", length = 3, nullable = false)
    public Long getId(){return id_user;}

    public void setId(Long id){this.id_user = id;}

    @Column(name = "Login", length = 20, nullable = false)
    public String getLogin(){return login;}
    public void setLogin(String login){this.login = login;}

    @Column(name = "Password", length = 6, nullable = false)
    public String getPassword(){return password;}
    public void setPassword(String password) {this.password = password;}

    @Column(name = "Country", length = 30, nullable = false)
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    @Column(name = "Sex", length = 7, nullable = false)
    public String getSex() {return sex;}
    public void setSex(String sex){this.sex = sex;}

    @Override
    public String toString(){
        return "User{" +
                "id=" + id_user +
                ", login='" + login  +
                ", password='" + password  +
                ", country='" + country  +
                ", sex='" + sex  +
                '}';
    }
}
