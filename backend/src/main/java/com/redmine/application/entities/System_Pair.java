package com.redmine.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_pair")
public class System_Pair {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;
    private long A_SystemID;
    private long B_SystemID;

    protected System_Pair() {    }

    public System_Pair(long ID, long A_SystemID, long B_SystemID) {
        this.ID = ID;
        this.A_SystemID = A_SystemID;
        this.B_SystemID = B_SystemID;
    }

    public long getId() {
        return ID;
    }

    public long getA_SystemID() {
        return A_SystemID;
    }

    public long getB_SystemID() {
        return B_SystemID;
    }

    @Override
    public String toString() {
        return "com.redmine.application.entities.System_Pair{" + "ID=" + ID + ", A_ID=" + A_SystemID + "B_ID=" + B_SystemID + "}";
    }


}
