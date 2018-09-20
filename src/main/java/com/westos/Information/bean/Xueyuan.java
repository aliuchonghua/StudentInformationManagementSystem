package com.westos.Information.bean;

import java.util.Objects;

public class Xueyuan {
    private Integer xueid;
    private String xuename;

    @Override
    public String toString() {
        return "Xueyuan{" +
                "xueid=" + xueid +
                ", xuename='" + xuename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xueyuan xueyuan = (Xueyuan) o;
        return Objects.equals(xueid, xueyuan.xueid) &&
                Objects.equals(xuename, xueyuan.xuename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xueid, xuename);
    }

    public Integer getXueid() {
        return xueid;
    }

    public void setXueid(Integer xueid) {
        this.xueid = xueid;
    }

    public String getXuename() {
        return xuename;
    }

    public void setXuename(String xuename) {
        this.xuename = xuename;
    }
}
