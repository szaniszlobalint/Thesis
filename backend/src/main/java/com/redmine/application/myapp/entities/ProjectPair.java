package com.redmine.application.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "project_pair")
public class ProjectPair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    @Column(name="a_projectid", nullable = false, unique = true)
    private long aid;
    @Column(name="b_projectid", nullable = false, unique = true)
    private long bid;
    protected ProjectPair() {
    }

    public ProjectPair(long ID, long aid, long bid) {
        this.ID = ID;
        this.aid = aid;
        this.bid = bid;
    }

    public long getID() {
        return ID;
    }

    public long getAid() {
        return aid;
    }

    public long getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "com.redmine.application.myapp.entities.System{" + "ID=" + ID + "A_ID=" + aid + "B_ID=" + bid +"}";
    }


}
