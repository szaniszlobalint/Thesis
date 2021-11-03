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
    private String description;

    protected Project() {    }

    public Project(long ID, String name, String identifier, String description) {
        this.ID = ID;
        this.name = name;
        this.identifier = identifier;
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + ", name=" + name + "identifier="+ identifier +"description=" +description+  "}";
    }


}
