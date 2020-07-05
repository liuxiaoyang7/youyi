package com.cn.youyi.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {
    private int pid;
    private String pcontent;
    private String pimg;
    private Timestamp publishtime;
    private Integer ptid;
    private Integer uid;
    private Integer cid;
    private Integer pbid;
    private Commodity commodityByCid;

    @Id
    @Column(name = "pid", nullable = false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pcontent", nullable = true, length = 225)
    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    @Basic
    @Column(name = "pimg", nullable = true, length = 225)
    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Basic
    @Column(name = "publishtime", nullable = true)
    public Timestamp getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }

    @Basic
    @Column(name = "ptid", nullable = true)
    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    @Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "cid", nullable = true)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "pbid", nullable = true)
    public Integer getPbid() {
        return pbid;
    }

    public void setPbid(Integer pbid) {
        this.pbid = pbid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (pid != post.pid) return false;
        if (pcontent != null ? !pcontent.equals(post.pcontent) : post.pcontent != null) return false;
        if (pimg != null ? !pimg.equals(post.pimg) : post.pimg != null) return false;
        if (publishtime != null ? !publishtime.equals(post.publishtime) : post.publishtime != null) return false;
        if (ptid != null ? !ptid.equals(post.ptid) : post.ptid != null) return false;
        if (uid != null ? !uid.equals(post.uid) : post.uid != null) return false;
        if (cid != null ? !cid.equals(post.cid) : post.cid != null) return false;
        if (pbid != null ? !pbid.equals(post.pbid) : post.pbid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (pcontent != null ? pcontent.hashCode() : 0);
        result = 31 * result + (pimg != null ? pimg.hashCode() : 0);
        result = 31 * result + (publishtime != null ? publishtime.hashCode() : 0);
        result = 31 * result + (ptid != null ? ptid.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (pbid != null ? pbid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Commodity getCommodityByCid() {
        return commodityByCid;
    }

    public void setCommodityByCid(Commodity commodityByCid) {
        this.commodityByCid = commodityByCid;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pcontent='" + pcontent + '\'' +
                ", pimg='" + pimg + '\'' +
                ", publishtime=" + publishtime +
                ", ptid=" + ptid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", pbid=" + pbid +
                ", commodityByCid=" + commodityByCid +
                '}';
    }
}
