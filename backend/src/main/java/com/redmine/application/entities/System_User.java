package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_user")
public class System_User {

    @Id
    private long ID;
    private String firstname;
    private String lastname;
    private String login;
    private String mail;
    private boolean admin;

    protected System_User() {    }

    public System_User(long ID, String firstname, String lastname, String login, String mail, boolean admin) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.mail = mail;
        this.admin = admin;
    }

    public long getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "com.redmine.application.entities.System{" + "ID=" + ID + ", firstname=" + firstname +
                ", lastname=" + lastname + "login="+ login +"mail=" +mail+ "admin=" + admin + "}";
    }


}
