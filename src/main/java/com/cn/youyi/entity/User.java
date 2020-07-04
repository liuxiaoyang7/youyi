package com.cn.youyi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int uid;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String iDcard;
    private Integer experience;
    private String headphoto;
    private Integer typeid;
    private Integer yue;

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 4)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "IDcard", nullable = true, length = 20)
    public String getiDcard() {
        return iDcard;
    }

    public void setiDcard(String iDcard) {
        this.iDcard = iDcard;
    }

    @Basic
    @Column(name = "experience", nullable = true)
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "headphoto", nullable = true, length = 225)
    public String getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto;
    }

    @Basic
    @Column(name = "typeid", nullable = true)
    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "yue", nullable = true)
    public Integer getYue() {
        return yue;
    }

    public void setYue(Integer yue) {
        this.yue = yue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != user.uid) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (iDcard != null ? !iDcard.equals(user.iDcard) : user.iDcard != null) return false;
        if (experience != null ? !experience.equals(user.experience) : user.experience != null) return false;
        if (headphoto != null ? !headphoto.equals(user.headphoto) : user.headphoto != null) return false;
        if (typeid != null ? !typeid.equals(user.typeid) : user.typeid != null) return false;
        if (yue != null ? !yue.equals(user.yue) : user.yue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (iDcard != null ? iDcard.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (headphoto != null ? headphoto.hashCode() : 0);
        result = 31 * result + (typeid != null ? typeid.hashCode() : 0);
        result = 31 * result + (yue != null ? yue.hashCode() : 0);
        return result;
    }
}
