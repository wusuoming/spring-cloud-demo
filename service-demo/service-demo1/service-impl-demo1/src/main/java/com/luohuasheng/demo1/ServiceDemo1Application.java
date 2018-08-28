package com.luohuasheng.demo1;

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
@EnableSwagger2(resourcePackage = "com.luohuasheng", title = "DEMO1服务", description = "demo服务，实现两个数相加减，用来测试服务间调用与路由")
@SpringBootApplication
public class ServiceDemo1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo1Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.web(WebApplicationType.SERVLET);
    }

}
