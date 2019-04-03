package com.example.demo.weather.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Name WeatherVo
 * @Description
 * @Author wen
 * @Date 2019-03-27
 *            "province":"澳门",
 *             "city":"澳门特别行政区",
 *            "adcode":"820000",
 *            "weather":"晴",
 *            "temperature":"22",
 *            "winddirection":"东",
 *            "windpower":"≤3",
 *            "humidity":"86",
 *            "reporttime":"2019-03-27 19:54:45"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherVo implements Serializable{

    private static final long serialVersionUID = 1L;

    /** 地区 */
    private String province;

    /** 城市 */
    private String city;

    /** 城市代码 */
    private String adcode;

    /** 天气 */
    private String weather;

    /** 实时气温，单位：摄氏度 */
    private String temperature;

    /**  风向 */
    private String winddirection;

    /** 风力级别 */
    private String windpower;

    /** 空气湿度 */
    private String humidity;

    /** 数据发布时间 */
    private String reporttime;
}
