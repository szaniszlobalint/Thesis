package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_user_pair")
public class SystemUserPair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="auserid", nullable = false, unique = true)
    private long aid;
    @Column(name="buserid", nullable = false, unique = true)
    private long bid;

    protected SystemUserPair() {    }

    public SystemUserPair(long id, long aId, long bId) {
        this.id = id;
        this.aid = aId;
        this.bid = bId;
    }

    public long getID() {
        return id;
    }

    public long getAId() {
        return aid;
    }

    public long getBId() {
        return bid;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System_Pair{" + "ID=" + id + ", A_ID=" + aid + "B_ID=" + bid + "}";
    }


}
