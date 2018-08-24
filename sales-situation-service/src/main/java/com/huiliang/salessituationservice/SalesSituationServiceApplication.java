package com.huiliang.salessituationservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.huiliang.salessituationservice.mapper")
public class SalesSituationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesSituationServiceApplication.class, args);
	}
}
