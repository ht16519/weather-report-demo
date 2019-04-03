package com.example.demo.weather.job;

import com.example.demo.weather.domian.vo.CityVo;
import com.example.demo.weather.service.CityClient;
import com.example.demo.weather.service.WeatherCollectionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name WeatherDataSyncJob
 * @Description 天气数据同步执行器
 * @Author wen
 * @Date 2019-03-28
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherCollectionSerivce weatherCollectionSerivce;
    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("=================== START Weather Data Sync Job！===================");
        //1.获取城市code列表
        List<CityVo> cityVoList = new ArrayList<>();
        try {
            cityVoList = cityClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Weather Data Sync Job Exception: ", e);
        }
        //2.遍历城市code获取天气信息
        for (CityVo cityVo : cityVoList) {
            String cityCode = cityVo.getCityCode();
            weatherCollectionSerivce.syncDataByCityCode(cityCode);
            log.info("Weather Data Sync Job：cityCode:{}", cityCode);
        }
        log.info("=================== END ===================");
    }
}
