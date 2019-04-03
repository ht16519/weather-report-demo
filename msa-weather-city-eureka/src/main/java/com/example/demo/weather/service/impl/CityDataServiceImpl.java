package com.example.demo.weather.service.impl;

import com.example.demo.common.consts.CityConst;
import com.example.demo.weather.domian.vo.CityListVo;
import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.service.CityDataService;
import com.example.demo.weather.util.XmlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Name CityDataServiceImpl
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<CityVo> listCity() throws Exception{
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String citysStr = null;
        if(redisTemplate.hasKey(CityConst.CITY_LIST_INFO_REDIS_KEY)){
            citysStr = ops.get(CityConst.CITY_LIST_INFO_REDIS_KEY);
        }else{
            //1.读取xml文件
            Resource resource = new ClassPathResource("ctiy-list.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) !=  null){
                sb.append(line);
            }
            br.close();
            citysStr = sb.toString();
            if(!"".equals(citysStr)){
                ops.set(CityConst.CITY_LIST_INFO_REDIS_KEY, citysStr);
            }
        }
        //2.xml转为java对象
        return ((CityListVo) XmlBuilder.xmlStrToObj(CityListVo.class, citysStr)).getCityListVo();
    }

}
