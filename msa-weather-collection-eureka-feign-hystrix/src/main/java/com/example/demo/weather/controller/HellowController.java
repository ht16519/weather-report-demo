package com.example.demo.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Name WeatherController
 * @Description
 * @Author wen
 * @Date 2019-03-27
 */
@Controller
@RequestMapping("/index")
public class HellowController {

    /**
    * @Name index
    * @Description 起步测试
    * @Author wen
    * @Date 2019/3/27
    * @param
    * @return java.lang.String
    */
    @GetMapping("/hellow")
    @ResponseBody
    public String index(){
        return "hellow spring cloud!";
    }


}
