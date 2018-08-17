package com.luohuasheng.demo2;

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
@Import(CommonConfig.class)
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
