package com.example.demo.weather.service;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.weather.domian.vo.WeatherVo;

import java.util.List;

/**
 * @Name WeatherDataService
 * @Description
 * @Author wen
 * @Date 2019-03-27
 */
public interface WeatherDataService {

    /**
    * @Name getWeatherInfoByCityCode
    * @Description 通过城市代码获取天气信息
    * @Author wen
    * @Date 2019/3/27
    * @param
    * @return com.example.demo.weather.domian.vo.WeatherVo
    */
    WeatherVo getWeatherInfoByCityCode(String cityCode) throws BusinessException;


}
