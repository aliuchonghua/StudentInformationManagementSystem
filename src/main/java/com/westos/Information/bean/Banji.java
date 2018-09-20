package com.westos.Information.bean;

import java.util.Objects;

public class Banji {
    private Integer banid;
    private String banname;
    private Integer zhuanid;

    @Override
    public String toString() {
        return "Banji{" +
                "banid=" + banid +
                ", banname='" + banname + '\'' +
                ", zhuanid=" + zhuanid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banji banji = (Banji) o;
        return Objects.equals(banid, banji.banid) &&
                Objects.equals(banname, banji.banname) &&
                Objects.equals(zhuanid, banji.zhuanid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banid, banname, zhuanid);
    }

    public Integer getBanid() {
        return banid;
    }

    public void setBanid(Integer banid) {
        this.banid = banid;
    }

    public String getBanname() {
        return banname;
    }

    public void setBanname(String banname) {
        this.banname = banname;
    }

    public Integer getZhuanid() {
        return zhuanid;
    }

    public void setZhuanid(Integer zhuanid) {
        this.zhuanid = zhuanid;
    }
}
