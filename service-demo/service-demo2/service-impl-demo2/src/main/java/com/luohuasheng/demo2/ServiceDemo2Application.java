package com.luohuasheng.demo2;

import com.luohuasheng.annotation.EnableI18n;
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
@EnableI18n
@EnableSwagger2
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
