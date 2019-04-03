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
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityVo {

    @XmlAttribute(name = "d1")
    private String cityCode;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String citySuperior;
}
