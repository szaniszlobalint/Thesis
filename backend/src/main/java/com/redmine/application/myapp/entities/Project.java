package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private String name;
    private String identifier;
    private long systemid;
    private long redmineid;

    protected Project() {    }

    public Project(long ID, String name, String identifier, long systemid, long redmineid) {
        this.ID = ID;
        this.name = name;
        this.identifier = identifier;
        this.systemid = systemid;
        this.redmineid = redmineid;
    }

    public Project(String name, String identifier, long systemid, long redmineid) {
        this.name = name;
        this.identifier = identifier;
        this.systemid = systemid;
        this.redmineid = redmineid;
    }

    public Project(String name, long redmineid) {
        this.name = name;
        this.redmineid = redmineid;
    }



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public long getSystemid() {
        return systemid;
    }

    public void setSystemid(long systemid) {
        this.systemid = systemid;
    }

    public long getRedmineid() {
        return redmineid;
    }

    public void setRedmineid(long redmineid) {
        this.redmineid = redmineid;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + ", name=" + name + "identifier="+ identifier +"description=" +  "}";
    }


}
