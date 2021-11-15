package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_pair")
public class SystemPair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private long A_SystemID;
    private long B_SystemID;

    protected SystemPair() {    }

    public SystemPair(long ID, long A_SystemID, long B_SystemID) {
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
        return "com.redmine.application.myapp.entities.System_Pair{" + "ID=" + ID + ", A_ID=" + A_SystemID + "B_ID=" + B_SystemID + "}";
    }


}
