package com.example.demo.weather.service.impl;

import com.example.demo.common.consts.WeatherInfoConst;
import com.example.demo.weather.service.WeatherCollectionSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Name WeatherCollectionSerivceImpl
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@Service
public class WeatherCollectionSerivceImpl implements WeatherCollectionSerivce {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void syncDataByCityCode(String cityCode) {
        String url = WeatherInfoConst.GET_WEATHER_URL + cityCode;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        this.saveWeatherDate2Redis(url, ops);
    }

    /**
     * @Name saveWeatherDate2Redis
     * @Description 将天气数据存入redis缓存
     * @Author wen
     * @Date 2019/3/28
     * @param
     * @return void
     */
    private String saveWeatherDate2Redis(String key, ValueOperations<String, String> ops){
        String weatherStr = this.getWeatherStr(key);
        if (null != weatherStr) {
            ops.set(key, weatherStr, WeatherInfoConst.GET_WEATHER_INFO_BY_REDIS_TIME_OUT, TimeUnit.SECONDS);
        }
        return weatherStr;
    }

    /**
     * @param url
     * @return java.lang.String
     * @Name getWeatherStr
     * @Description 获取调用天气信息的结果字符串
     * @Author wen
     * @Date 2019/3/27
     */
    private String getWeatherStr(String url) {
        ResponseEntity<String> resStr = restTemplate.getForEntity(url, String.class);
        if (resStr.getStatusCodeValue() == 200) {
            return resStr.getBody();
        }
        return null;
    }
}
