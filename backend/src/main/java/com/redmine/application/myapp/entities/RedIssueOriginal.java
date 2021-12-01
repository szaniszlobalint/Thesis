package com.redmine.application.myapp.entities;

public class RedIssueOriginal {
    private String closed_on;
    private String created_on;
    private String description;
    private long done_ratio;
    private String due_date;
    private String start_date;

    public RedIssueOriginal(String closed_on, String created_on, String description, long done_ratio, String due_date,
                            String start_date, String updated_on, long estimated_hours,
                            boolean is_private, long author, long id, long tracker, String subject, long assigned_to,
                            long status, long priority, long systemid, long projectid) {
        this.closed_on = closed_on;
        this.created_on = created_on;
        this.description = description;
        this.done_ratio = done_ratio;
        this.due_date = due_date;
        this.start_date = start_date;
        this.updated_on = updated_on;
        this.estimated_hours = estimated_hours;
        this.is_private = is_private;
        this.author = author;
        this.id = id;
        this.tracker = tracker;
        this.subject = subject;
        this.assigned_to = assigned_to;
        this.status = status;
        this.priority = priority;
        this.systemid = systemid;
        this.projectid = projectid;
    }

    private String updated_on;
    private long estimated_hours;
    private boolean is_private;
    private long author;
    private long id;
    private long tracker;
    private String subject;
    private long assigned_to;
    private long status;
    private long priority;
    private long systemid;
    private long projectid;

    public String getClosed_on() {
        return closed_on;
    }

    public void setClosed_on(String closed_on) {
        this.closed_on = closed_on;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDone_ratio() {
        return done_ratio;
    }

    public void setDone_ratio(long done_ratio) {
        this.done_ratio = done_ratio;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public long getEstimated_hours() {
        return estimated_hours;
    }

    public void setEstimated_hours(long estimated_hours) {
        this.estimated_hours = estimated_hours;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
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
}
