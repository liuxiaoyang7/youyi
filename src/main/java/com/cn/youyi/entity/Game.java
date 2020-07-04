package com.cn.youyi.entity;

import javax.persistence.*;

@Entity
public class Game {
    private int gid;
    private String gname;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "gid", nullable = false)
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "gname", nullable = true, length = 20)
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (gid != game.gid) return false;
        if (gname != null ? !gname.equals(game.gname) : game.gname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        return result;
    }
}
