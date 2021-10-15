package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "stored_user")
public class App_User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;
    private String login;
    private String password;
    private String mail;

    protected App_User() {    }

    public App_User(long ID, String login, String password, String mail) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }

    public long getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "com.redmine.application.entities.System{" + "ID=" + ID +  "login="+ login +"password=" +password + "}";
    }


}
