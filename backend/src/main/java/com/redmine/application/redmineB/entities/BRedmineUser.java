package com.redmine.application.redmineB.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class BRedmineUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;
    private String login;
    private String firstname;
    private String lastname;
    private boolean admin;

    protected BRedmineUser() {    }


    public BRedmineUser(long ID, String login, String firstname, String lastname, boolean admin) {
        this.ID = ID;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.admin = admin;
    }

    public long getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "{" + "ID= " + ID +  " login= "+ login +" firstname= " + firstname + " lastname= " + lastname + " admin= " + admin + "}";
    }


}
