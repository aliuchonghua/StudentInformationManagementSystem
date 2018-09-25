package com.westos.Information.bean;

import java.util.Objects;

public class City {
    private String shengfen;

    @Override
    public String toString() {
        return "City{" +
                "shengfen='" + shengfen + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(shengfen, city.shengfen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shengfen);
    }

    public String getShengfen() {
        return shengfen;
    }

    public void setShengfen(String shengfen) {
        this.shengfen = shengfen;
    }
}
