package com.example.demo.consts;

/**
 * @Name WeatherInfoConst
 * @Description
 * @Author wen
 * @Date 2019-03-27
 */
public interface WeatherInfoConst {

    /**  调用天气的接口地址 */
    String GET_WEATHER_URL = "https://restapi.amap.com/v3/weather/weatherInfo?key=f51125d1ba4a128fade1355de42230b8&city=";

    /**  从redis获取天气信息的缓存超时时间 */
    long GET_WEATHER_INFO_BY_REDIS_TIME_OUT = 60 * 30;

    /**  定时调度同步城市天气信息间隔时长 */
    int SYNC_WEATHER_INFO_INTERVAL_DURATION = 60 * 30;
}
