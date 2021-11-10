package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String login;
    private String mail;
    private boolean admin;
    private long systemid;
    private long redmineid;

    protected SystemUser() {    }



    public SystemUser(long id, String firstname, String lastname, String login, String mail, boolean admin, long systemid, long redmineid) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.mail = mail;
        this.admin = admin;
        this.systemid = systemid;
        this.redmineid = redmineid;
    }

    public long getId() {
        return id;
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

    public long getSystemid() {
        return systemid;
    }

    public long getRedmineid() {
        return redmineid;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + id + ", firstname=" + firstname +
                ", lastname=" + lastname + "login="+ login +"mail=" +mail+ "admin=" + admin + "systemID=" + systemid + " redmineID= "+ redmineid+ "}";
    }


}
