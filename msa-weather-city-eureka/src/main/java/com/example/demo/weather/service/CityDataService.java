package com.example.demo.weather.service;

import com.example.demo.weather.domian.vo.CityVo;

import java.util.List;

/**
 * @Name CityDataService
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
public interface CityDataService {

    /**
    * @Name listCity
    * @Description 获取城市列表
    * @Author wen
    * @Date 2019/3/28
    * @param
    * @return java.util.List<com.example.demo.weather.domian.vo.CityVo>
    */
    List<CityVo> listCity() throws Exception;


}
