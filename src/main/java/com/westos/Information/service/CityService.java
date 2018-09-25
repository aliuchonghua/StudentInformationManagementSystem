package com.westos.Information.service;

import com.westos.Information.bean.City;

import java.util.List;

public interface CityService {

    //获取省份
    List<String> getProvinces();

    //    获取城市
    List<String> getCity(City city);
}
