package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "system")
public class Stored_System {

    @Id
    private long ID;
    private String type;

    protected Stored_System() {    }

    public Stored_System(long ID, String type) {
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
        return "com.redmine.application.entities.System{" + "ID=" + ID + ", name=" + type + "}";
    }


}
