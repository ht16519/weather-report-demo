package com.example.demo.weather.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Name CityVo
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityVo {

    private String cityCode;

    private String cityName;

    private String citySuperior;
}
