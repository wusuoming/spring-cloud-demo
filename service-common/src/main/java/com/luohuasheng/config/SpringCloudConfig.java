package com.luohuasheng.config;

import com.luohuasheng.rule.TestModel;
import com.luohuasheng.rule.TestRandomRule;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
@ComponentScan(basePackages = "${component.base.package:com.luohuasheng}")
@EnableFeignClients(basePackages = "${component.base.package:com.luohuasheng}")
public class SpringCloudConfig implements WebMvcConfigurer {
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/hystrix/**")
                .addResourceLocations("classpath:/static/hystrix/");
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    @ConditionalOnProperty(value = "spring.cloud.test.model", matchIfMissing = false)
    public IRule ribbonRule(@Value("${spring.cloud.test.model}") TestModel model) {
        return new TestRandomRule(model);
    }


}
