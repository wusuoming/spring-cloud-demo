package com.luohuasheng.demo2;

import com.luohuasheng.annotation.EnableSpringCloud;
import com.luohuasheng.annotation.EnableSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author panda
 */
@EnableSpringCloud
@EnableSwagger2(resourcePackage = "com.luohuasheng", title = "DEMO2服务", description = "demo服务，实现两个数相加减，用来测试服务间调用与路由")
@SpringBootApplication
public class ServiceDemo2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo2Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.web(WebApplicationType.SERVLET);
    }

}
