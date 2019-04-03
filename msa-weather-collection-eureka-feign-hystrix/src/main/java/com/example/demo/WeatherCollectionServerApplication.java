package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient	//开启注册到注册中心
@EnableFeignClients     //启用客户端发现
@EnableCircuitBreaker	//开启熔断机制
public class WeatherCollectionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCollectionServerApplication.class, args);
	}

}
