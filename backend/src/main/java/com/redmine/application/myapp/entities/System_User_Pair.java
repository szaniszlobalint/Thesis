package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_user_pair")
public class System_User_Pair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long auserid;
    private long buserid;

    protected System_User_Pair() {    }

    public System_User_Pair(long id, long auserid, long buserid) {
        this.id = id;
        this.auserid = auserid;
        this.buserid = buserid;
    }

    public long getID() {
        return id;
    }

    public long getAuserid() {
        return auserid;
    }

    public long getBuserid() {
        return buserid;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System_Pair{" + "ID=" + id + ", A_ID=" + auserid + "B_ID=" + buserid + "}";
    }


}
