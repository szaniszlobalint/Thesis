package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class App_User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;
    private String username;
    private String password;
    private String mail;

    protected App_User() {    }

    public App_User(long ID, String username, String password, String mail) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public long getID() {
        return ID;
    }

    public String getLogin() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "com.redmine.application.entities.System{" + "ID=" + ID +  "login="+ username +"password=" +password + "}";
    }


}
