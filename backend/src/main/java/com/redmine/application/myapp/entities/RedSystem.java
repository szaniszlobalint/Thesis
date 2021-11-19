package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system")
public class RedSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private String type;
    private String name;

    protected RedSystem() {    }

    public RedSystem(long ID, String type, String name) {
        this.ID = ID;
        this.type = type;
        this.type = name;
    }

    public long getId() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + ", name=" + type + ", name=" + name + "}";
    }


}
