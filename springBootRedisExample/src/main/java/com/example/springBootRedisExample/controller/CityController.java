package com.example.springBootRedisExample.controller;

import com.example.springBootRedisExample.model.City;
import com.example.springBootRedisExample.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {


    @Autowired
    private RedisService redisService;


//    http://localhost:8888/saveCity?cityName=北京&cityIntroduce=中國首都&cityId=1
    @GetMapping(value = "saveCity")
    public String saveCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        redisService.set(cityId+"",city);
        return "success";
    }



//    http://localhost:8888/getCityById?cityId=1
    @GetMapping(value = "getCityById")
    public City getCity(int cityId){
        City city = (City) redisService.get(cityId+"");
        return city;
    }

}
