package com.luohuasheng;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceDemo1Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceDemo1Application.class).web(true).run(args);
    }

}
