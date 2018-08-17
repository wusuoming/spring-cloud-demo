package com.luohuasheng;


import com.luohuasheng.config.CommonConfig;
import com.luohuasheng.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


/**
 * @author panda
 */
@EnableZuulProxy
@SpringCloudApplication

@Import(CommonConfig.class)
public class ZuulApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.web(WebApplicationType.SERVLET);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}
