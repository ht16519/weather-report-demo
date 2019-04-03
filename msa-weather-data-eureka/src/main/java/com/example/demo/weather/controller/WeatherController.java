package com.example.demo.weather.controller;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.common.web.response.WebApiResult;
import com.example.demo.weather.domian.vo.WeatherVo;
import com.example.demo.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Name WeatherController
 * @Description
 * @Author wen
 * @Date 2019-03-27
 */
@Controller
@RequestMapping("/report")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    /**
    * @Name getWeatherByCityCode
    * @Description 通过城市代码获取天气信息
    * @Author wen
    * @Date 2019/3/27
    * @param cityCode
    * @return com.example.demo.common.web.response.WebApiResult
    */
    @GetMapping("/code/{cityCode}")
    @ResponseBody
    public WeatherVo getWeatherByCityCode(@PathVariable("cityCode") String cityCode) throws BusinessException {
        return weatherDataService.getWeatherInfoByCityCode(cityCode);
    }

    /**
    * @Name index
    * @Description 起步测试
    * @Author wen
    * @Date 2019/3/27
    * @param
    * @return java.lang.String
    */
    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return "hellow spring cloud!";
    }


}
