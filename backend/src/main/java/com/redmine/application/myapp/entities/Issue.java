package com.redmine.application.myapp.entities;

public class Issue {
    private long id;
    private long tracker;
    private String subject;
    private long assigned_to;
    private long status;
    private long priority;
    private long systemid;
    private long projectid;

    public Issue(long id, long tracker, String subject, long assigned_to, long status, long priority, long systemid, long projectid) {
        this.id = id;
        this.tracker = tracker;
        this.subject = subject;
        this.assigned_to = assigned_to;
        this.status = status;
        this.priority = priority;
        this.systemid = systemid;
        this.projectid = projectid;
    }

    public Issue(long id, long tracker, String subject, long status, long priority, long systemid, long projectid) {
        this.id = id;
        this.tracker = tracker;
        this.subject = subject;
        this.status = status;
        this.priority = priority;
        this.systemid = systemid;
        this.projectid = projectid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTracker() {
        return tracker;
    }

    public void setTracker(long tracker) {
        this.tracker = tracker;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(long assigned_to) {
        this.assigned_to = assigned_to;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public long getSystemid() {
        return systemid;
    }

    public void setSystemid(long systemid) {
        this.systemid = systemid;
    }

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", tracker=" + tracker +
                ", subject='" + subject + '\'' +
                ", assigned_to=" + assigned_to +
                ", status=" + status +
                ", priority=" + priority +
                ", systemid=" + systemid +
                ", projectid=" + projectid +
                '}';
    }
}
