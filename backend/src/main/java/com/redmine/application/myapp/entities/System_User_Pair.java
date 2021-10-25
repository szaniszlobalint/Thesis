package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_user_pair")
public class System_User_Pair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private long A_UserID;
    private long B_UserID;

    protected System_User_Pair() {    }

    public System_User_Pair(long ID, long a_UserID, long b_UserID) {
        this.ID = ID;
        A_UserID = a_UserID;
        B_UserID = b_UserID;
    }

    public long getID() {
        return ID;
    }

    public long getA_UserID() {
        return A_UserID;
    }

    public long getB_UserID() {
        return B_UserID;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System_Pair{" + "ID=" + ID + ", A_ID=" + A_UserID + "B_ID=" + B_UserID + "}";
    }


}
