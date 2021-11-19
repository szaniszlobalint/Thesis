package com.redmine.application.myapp.entities;

public class RedmineOriginal {

    private long id;
    private String firstname;
    private String lastname;
    private String login;
    private String mail;
    private boolean admin;
    private String created_on;
    private String updated_on;
    private String last_login_on;
    private String passwd_changed_on;
    private String twofa_scheme;

    protected RedmineOriginal() { }

    public RedmineOriginal(long id, String firstname, String lastname, String login, String mail,
                           boolean admin, String created_on, String updated_on, String last_login_on,
                           String passwd_changed_on, String twofa_scheme) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.mail = mail;
        this.admin = admin;
        this.created_on = created_on;
        this.updated_on = updated_on;
        this.last_login_on = last_login_on;
        this.passwd_changed_on = passwd_changed_on;
        this.twofa_scheme = twofa_scheme;
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

    public String getCreated_on() {
        return created_on;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public String getLast_login_on() {
        return last_login_on;
    }

    public String getPasswd_changed_on() {
        return passwd_changed_on;
    }

    public String getTwofa_scheme() {
        return twofa_scheme;
    }
}
