package com.westos.Information.controller;

import com.westos.Information.bean.City;
import com.westos.Information.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //返回省份
    @RequestMapping(value = "/sheng", method = RequestMethod.GET)
    public List<String> getProvinces() {
        return cityService.getProvinces();
    }

    //返回城市
    @RequestMapping(value = "/shi", method = RequestMethod.POST)
    public List<String> getCity(@RequestBody City city) {
        return cityService.getCity(city);
    }

}
