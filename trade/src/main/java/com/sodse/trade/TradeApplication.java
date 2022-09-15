package com.sodse.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.sodse.trade.mapper")
@SpringBootApplication
@EnableCaching
//@EnableScheduling

//@EnableDiscoveryClient //开启发现服务功能
public class TradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class, args);
    }

//    @Bean
//    @LoadBalanced//使用负载均衡机制
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
