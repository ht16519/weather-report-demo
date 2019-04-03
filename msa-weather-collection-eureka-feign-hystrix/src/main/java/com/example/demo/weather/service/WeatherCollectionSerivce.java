package com.example.demo.weather.service;

/**
 * @Name WeatherCollectionSerivce
 * @Description 天气信息采集服务层
 * @Author wen
 * @Date 2019-03-28
 */
public interface WeatherCollectionSerivce {

    /**
     * @Name syncDataByCityId
     * @Description 通过城市code采集同步城市数据
     * @Author wen
     * @Date 2019/3/28
     * @param cityCode
     * @return void
     */
    void syncDataByCityCode(String cityCode);

}
