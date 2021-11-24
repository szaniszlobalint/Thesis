package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "system_pair")
public class SystemPair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;

    @Column(name="a_systemid", nullable = false, unique = false)
    private long aId;
    @Column(name="b_systemid", nullable = false, unique = false)
    private long bId;

    protected SystemPair() {    }

    public SystemPair(long ID, long aId, long bId) {
        this.ID = ID;
        this.aId = aId;
        this.bId = bId;
    }

    public long getId() {
        return ID;
    }

    public long getAId() {
        return aId;
    }

    public long getBId() {
        return bId;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System_Pair{" + "ID=" + ID + ", A_ID=" + aId + "B_ID=" + bId + "}";
    }


}
