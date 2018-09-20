package com.westos.Information.bean;


import java.util.Date;
import java.util.Objects;

public class Student {
    private Integer stuid;
    private String name;
    private String sex;
    private String nation;
    private Date birth;
    private String addr;
    private String phone;
    private Integer xueid;
    private String xuename;
    private Integer zhuanid;
    private String zhuanname;
    private Integer banid;
    private String banname;
    private Date enrol;
    private String pass;

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birth=" + birth +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                ", xueid=" + xueid +
                ", zhuanid=" + zhuanid +
                ", banid=" + banid +
                ", enrol=" + enrol +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuid, student.stuid) &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(nation, student.nation) &&
                Objects.equals(birth, student.birth) &&
                Objects.equals(addr, student.addr) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(xueid, student.xueid) &&
                Objects.equals(zhuanid, student.zhuanid) &&
                Objects.equals(banid, student.banid) &&
                Objects.equals(enrol, student.enrol) &&
                Objects.equals(pass, student.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuid, name, sex, nation, birth, addr, phone, xueid, zhuanid, banid, enrol, pass);
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getXueid() {
        return xueid;
    }

    public void setXueid(Integer xueid) {
        this.xueid = xueid;
    }

    public Integer getZhuanid() {
        return zhuanid;
    }

    public void setZhuanid(Integer zhuanid) {
        this.zhuanid = zhuanid;
    }

    public Integer getBanid() {
        return banid;
    }

    public void setBanid(Integer banid) {
        this.banid = banid;
    }

    public Date getEnrol() {
        return enrol;
    }

    public void setEnrol(Date enrol) {
        this.enrol = enrol;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getXuename() {
        return xuename;
    }

    public void setXuename(String xuename) {
        this.xuename = xuename;
    }

    public String getZhuanname() {
        return zhuanname;
    }

    public void setZhuanname(String zhuanname) {
        this.zhuanname = zhuanname;
    }

    public String getBanname() {
        return banname;
    }

    public void setBanname(String banname) {
        this.banname = banname;
    }
}
