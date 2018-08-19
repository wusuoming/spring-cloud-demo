package com.luohuasheng.demo1;

import com.luohuasheng.annotation.EnableSpringCloud;
import com.luohuasheng.config.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author panda
 */
@SpringBootApplication
@EnableSpringCloud
public class ServiceDemo1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo1Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.web(WebApplicationType.SERVLET);
    }

}
