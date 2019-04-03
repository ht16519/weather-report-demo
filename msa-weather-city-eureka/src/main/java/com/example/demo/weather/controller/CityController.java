package com.example.demo.weather.controller;

import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Name CityController
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/list")
    public List<CityVo> listCity() throws Exception {
        return cityDataService.listCity();
    }


}
