package com.example.demo.weather.service;

import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.fallback.CityClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Name CityClient
 * @Description
 * @Author wen
 * @Date 2019-03-30
 */
@FeignClient(name = "MSA-WEATHER-DATA-EUREKA", fallback = CityClientFallback.class)
public interface CityClient {

    @GetMapping("/city/list")
    List<CityVo> listCity();

}
