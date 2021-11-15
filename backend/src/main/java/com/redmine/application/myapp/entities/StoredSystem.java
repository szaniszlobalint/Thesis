package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system")
public class StoredSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private String type;

    protected StoredSystem() {    }

    public StoredSystem(long ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public long getId() {
        return ID;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + ", name=" + type + "}";
    }


}
