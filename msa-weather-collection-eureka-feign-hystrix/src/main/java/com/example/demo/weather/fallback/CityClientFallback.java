package com.example.demo.weather.fallback;

import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.service.CityClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name CityClientFallback
 * @Description 城市列表熔断回调
 * @Author wen
 * @Date 2019-03-30
 */
@Component
public class CityClientFallback implements CityClient{

    @Override
    public List<CityVo> listCity() {
        List<CityVo> cityList = new ArrayList<>();
        CityVo cityVo = new CityVo();
        cityVo.setCityCode("130300");
        cityVo.setCityName("秦皇岛市");
        cityVo.setCitySuperior("河北省");
        CityVo cityVo1 = new CityVo();
        cityVo1.setCityCode("130400");
        cityVo1.setCityName("邯郸市");
        cityVo1.setCitySuperior("河北省");
        cityList.add(cityVo);
        cityList.add(cityVo1);
        return cityList;
    }

}
