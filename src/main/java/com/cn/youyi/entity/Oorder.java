package com.cn.youyi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Oorder {
    private int oid;
    private Integer orderState;
    private Timestamp buyTime;
    private Integer userid;
    private Integer cid;

    @Id
    @Column(name = "oid", nullable = false)
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "order_state", nullable = true)
    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "buy_time", nullable = true)
    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "cid", nullable = true)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oorder oorder = (Oorder) o;

        if (oid != oorder.oid) return false;
        if (orderState != null ? !orderState.equals(oorder.orderState) : oorder.orderState != null) return false;
        if (buyTime != null ? !buyTime.equals(oorder.buyTime) : oorder.buyTime != null) return false;
        if (userid != null ? !userid.equals(oorder.userid) : oorder.userid != null) return false;
        if (cid != null ? !cid.equals(oorder.cid) : oorder.cid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (buyTime != null ? buyTime.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Oorder{" +
                "oid=" + oid +
                ", orderState=" + orderState +
                ", buyTime=" + buyTime +
                ", userid=" + userid +
                ", cid=" + cid +
                '}';
    }
}
