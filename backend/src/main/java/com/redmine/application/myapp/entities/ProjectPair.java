package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "project_pair")
public class ProjectPair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private long A_ProjectID;
    private long B_ProjectID;

    protected ProjectPair() {
    }

    public ProjectPair(long ID, long a_ProjectID, long b_ProjectID) {
        this.ID = ID;
        A_ProjectID = a_ProjectID;
        B_ProjectID = b_ProjectID;
    }

    public long getID() {
        return ID;
    }

    public long getA_ProjectID() {
        return A_ProjectID;
    }

    public long getB_ProjectID() {
        return B_ProjectID;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + "A_ID=" + A_ProjectID + "B_ID=" + B_ProjectID +"}";
    }


}
