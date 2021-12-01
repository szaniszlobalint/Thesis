package com.redmine.application.myapp.entities;

public class IssueTracker {
    private long id;
    private String name;

    public IssueTracker() {
    }

    public IssueTracker(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IssueTracker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
