package com.example.springBootRedisExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

//    serialVersionUID是一个随机的long值，用来保证类的安全性，防止反序列化攻击。
    private static final long serialVersionUID = 1L;
    private int cityId;
    private String cityName;
    private String cityIntroduce;

}
