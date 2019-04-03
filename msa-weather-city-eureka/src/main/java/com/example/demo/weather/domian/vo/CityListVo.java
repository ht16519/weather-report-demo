package com.example.demo.weather.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Name CityListVo
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityListVo {

    @XmlElement(name = "d")
    private List<CityVo> cityListVo;
}
