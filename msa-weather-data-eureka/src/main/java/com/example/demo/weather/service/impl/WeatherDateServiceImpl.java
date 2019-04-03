package com.example.demo.weather.service.impl;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.common.web.error.EmError;
import com.example.demo.consts.WeatherInfoConst;
import com.example.demo.weather.domian.vo.WeatherVo;
import com.example.demo.weather.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Name WeatherDateServiceImpl
 * @Description
 * @Author wen
 * @Date 2019-03-27
 */
@Service
@Slf4j
public class WeatherDateServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public WeatherVo getWeatherInfoByCityCode(String cityCode) throws BusinessException {
        String url = WeatherInfoConst.GET_WEATHER_URL + cityCode;
        String weatherStr = null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(url)) {
            log.info("=================get weather info by redis！===================");
            weatherStr = ops.get(url);
            log.info("===================" + weatherStr + "===================");
        } else {
            log.error("===================no found weather info by redis！===================");
            throw new BusinessException(EmError.GET_WEATHER_INFO_ERROR);
        }
        return this.getWeatherVo(weatherStr);
    }

    /**
     * @param weatherStr
     * @return com.example.demo.weather.domian.vo.WeatherVo
     * @Name getWeatherVo
     * @Description 转为将天气信息字符串转为天气VO对象
     * @Author wen
     * @Date 2019/3/27
     */
    private WeatherVo getWeatherVo(String weatherStr) throws BusinessException {
        WeatherVo weatherVo = new WeatherVo();
        if (null != weatherStr) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Map map = mapper.readValue(weatherStr, Map.class);
                if (map != null) {
                    Map<String, String> weatherVoMap = ((ArrayList<Map>) map.get("lives")).get(0);
                    weatherVo.setProvince(weatherVoMap.get("province"));
                    weatherVo.setCity(weatherVoMap.get("city"));
                    weatherVo.setAdcode(weatherVoMap.get("adcode"));
                    weatherVo.setWeather(weatherVoMap.get("weather"));
                    weatherVo.setTemperature(weatherVoMap.get("temperature"));
                    weatherVo.setWinddirection(weatherVoMap.get("winddirection"));
                    weatherVo.setWindpower(weatherVoMap.get("windpower"));
                    weatherVo.setHumidity(weatherVoMap.get("humidity"));
                    weatherVo.setReporttime(weatherVoMap.get("reporttime"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException(EmError.GET_WEATHER_INFO_ERROR);
            }
        }
        return weatherVo;
    }
}
