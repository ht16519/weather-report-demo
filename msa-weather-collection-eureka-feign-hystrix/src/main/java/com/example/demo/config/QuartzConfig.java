package com.example.demo.config;

import com.example.demo.common.consts.WeatherInfoConst;
import com.example.demo.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Name QuartzConfig
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
@Configuration
public class QuartzConfig {

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                    .storeDurably().build();
    }

    //Trigger
    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(WeatherInfoConst.SYNC_WEATHER_INFO_INTERVAL_DURATION).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(schedBuilder).build();
    }
}
