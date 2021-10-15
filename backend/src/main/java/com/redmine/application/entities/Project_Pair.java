package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "project_pair")
public class Project_Pair {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;
    private long A_ProjectID;
    private long B_ProjectID;

    protected Project_Pair() {
    }

    public Project_Pair(long ID, long a_ProjectID, long b_ProjectID) {
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
        return "com.redmine.application.entities.System{" + "ID=" + ID + "A_ID=" + A_ProjectID + "B_ID=" + B_ProjectID +"}";
    }


}
