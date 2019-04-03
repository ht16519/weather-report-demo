package com.example.demo.weather.service;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.domian.vo.WeatherVo;
import com.example.demo.weather.fallback.GatewayClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Name GatewayClient
 * @Description
 * @Author wen
 * @Date 2019-03-29
 *///         msa-weather-eureka-client-use-zuul
@FeignClient(name = "MSA-WEATHER-EUREKA-USE-ZUUL", fallback = GatewayClientFallback.class)
public interface GatewayClient {

    @GetMapping("/city/city/list")
    List<CityVo> listCity();

    @GetMapping("/data/report/code/{cityCode}")
    WeatherVo getWeatherByCityCode(@PathVariable("cityCode") String cityCode) throws BusinessException;
}
