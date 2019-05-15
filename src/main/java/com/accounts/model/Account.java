package com.accounts.model;

import javax.persistence.*;

/**
 * Model class - a POJO containing get/set methods to store data retrieved using DAOImpl class
 * + this in @Entity class, one which maps data objects with the database
 */

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "website")
    private String website;

    @Column(name = "login")
    private String login;

    @Column(name = "passwords")
    private String password;

    // entity class should contain an empty constructor
    // findall() method does not work without empty constructor
    public Account() {
    }

    public Account(String website, String login, String password) {
        this.website = website;
        this.login = login;
        this.password = password;
    }

    public Account(long id, String website, String login, String password) {
        this.id = id;
        this.website = website;
        this.login = login;
        this.password = password;
    }

    public Account(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", website='" + website + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
