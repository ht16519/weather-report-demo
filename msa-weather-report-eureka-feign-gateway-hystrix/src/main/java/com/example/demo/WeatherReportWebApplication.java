package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient	//启用注册服务到注册中心
@EnableFeignClients		//启用客户端发现
@EnableCircuitBreaker	//启用熔断器
public class WeatherReportWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReportWebApplication.class, args);
	}

}
