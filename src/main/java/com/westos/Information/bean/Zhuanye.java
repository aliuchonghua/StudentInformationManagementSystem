package com.westos.Information.bean;

import java.util.Objects;

public class Zhuanye {
    private Integer zhuanid;
    private Integer xueid;
    private String zhuanname;

    @Override
    public String toString() {
        return "Zhuanye{" +
                "zhuanid=" + zhuanid +
                ", xueid=" + xueid +
                ", zhuanname='" + zhuanname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zhuanye zhuanye = (Zhuanye) o;
        return Objects.equals(zhuanid, zhuanye.zhuanid) &&
                Objects.equals(xueid, zhuanye.xueid) &&
                Objects.equals(zhuanname, zhuanye.zhuanname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zhuanid, xueid, zhuanname);
    }

    public Integer getZhuanid() {
        return zhuanid;
    }

    public void setZhuanid(Integer zhuanid) {
        this.zhuanid = zhuanid;
    }

    public Integer getXueid() {
        return xueid;
    }

    public void setXueid(Integer xueid) {
        this.xueid = xueid;
    }

    public String getZhuanname() {
        return zhuanname;
    }

    public void setZhuanname(String zhuanname) {
        this.zhuanname = zhuanname;
    }
}
