package com.luohuasheng.config;

import com.luohuasheng.controller.ClientController;
import com.luohuasheng.exception.BaseExceptionHandler;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author panda
 */
@Configuration
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.luohuasheng")
@ComponentScan("com.luohuasheng")
public class CommonConfig {

    @Bean
    public ClientController client() {
        return new ClientController();
    }

    @Bean
    public BaseExceptionHandler baseExceptionHandler() {
        return new BaseExceptionHandler();
    }

}
