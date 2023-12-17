package com.example.hello_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    private Integer id;
    private String login;
    private String password;
    private String country;
    private String sex;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course")
    @TableGenerator(
            name="course",
            table="GENERATOR_TABLE",
            pkColumnName = "key",
            valueColumnName = "next",
            pkColumnValue="course",
            allocationSize=30
    )
    @Column(name = "Id")
    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

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

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
