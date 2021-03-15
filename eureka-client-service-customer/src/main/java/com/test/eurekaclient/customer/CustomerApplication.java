package com.test.eurekaclient.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

// 开启Hystrix的断路器
@EnableCircuitBreaker
// 开启Hystrix监控
@EnableHystrixDashboard
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
// 开启ribbon重试机制
@EnableRetry
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
