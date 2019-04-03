package com.example.demo.weather.controller;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.domian.vo.WeatherVo;
import com.example.demo.weather.service.GatewayClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    private GatewayClient gatewayClient;

    /**
    * @Name getWeatherByCityCode
    * @Description 通过城市代码获取天气信息
    * @Author wen
    * @Date 2019/3/27
    * @param cityCode
    * @return com.example.demo.common.web.response.WebApiResult
    */
    @GetMapping("/code/{cityCode}")
    public ModelAndView getWeatherByCityCode(@PathVariable("cityCode") String cityCode, Model model) throws Exception {
        return this.getModelAndView(cityCode, model);
    }

    /**
    * @Name getWeatherByCityCode
    * @Description 测试熔断机制
    * @Author wen
    * @Date 2019/3/30
    * @param cityCode
    * @param model
    * @return org.springframework.web.servlet.ModelAndView
    */
    @GetMapping("/code/fallback/{cityCode}")
    public ModelAndView getWeatherByCityCodeFallback(@PathVariable("cityCode") String cityCode, Model model) throws Exception {
        return this.getModelAndView(cityCode, model);
    }


    private ModelAndView getModelAndView(@PathVariable("cityCode") String cityCode, Model model) throws BusinessException {
        WeatherVo weatherInfo = gatewayClient.getWeatherByCityCode(cityCode);
        List<CityVo> cityVoList = gatewayClient.listCity();
        model.addAttribute("title", "我的天气预报");
        model.addAttribute("citys", cityVoList);
        model.addAttribute("cityCode", cityCode);
        model.addAttribute("weatherInfo", weatherInfo);
        return new ModelAndView("report", "info", model);
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
