package com.luohuasheng;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.luohuasheng.filter.AccessFilter;
import org.apache.http.entity.ContentType;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author panda
 */

@SpringCloudApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.web(WebApplicationType.SERVLET);
    }

    @Bean(name = "zuul.CONFIGURATION_PROPERTIES")
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    SwaggerFilter swaggerFilter() {
        return new SwaggerFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(SwaggerFilter swaggerFilter) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(swaggerFilter);
        registration.addUrlPatterns("/swagger-resources");
        registration.setName("swaggerFilter");
        registration.setOrder(1);
        return registration;
    }


    public class SwaggerFilter implements Filter {
        @Autowired
        private ZuulProperties zuulProperties;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                throws IOException, ServletException {
            List<Map> swaggerResources = new ArrayList<>();
            Map<String, String> swaggerResource = new HashMap<>(0);
            swaggerResource.put("name", "default");
            swaggerResource.put("url", "/v2/api-docs");
            swaggerResource.put("swaggerVersion", "2.0");
            swaggerResource.put("location", "/v2/api-docs");
            swaggerResources.add(swaggerResource);
            for (ZuulProperties.ZuulRoute route : zuulProperties.getRoutes().values()) {
                Map<String, String> routeResource = new HashMap<>(0);
                String path = route.getPath().replaceAll("\\*","");
                path = path.lastIndexOf("/")>0?path.substring(0,path.length()-1):path;
                routeResource.put("name", path);
                routeResource.put("url", path + "/v2/api-docs");
                routeResource.put("swaggerVersion", "2.0");
                routeResource.put("location", path + "/v2/api-docs");
                swaggerResources.add(routeResource);
            }
            servletResponse.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            ObjectMapper mapper = new ObjectMapper();
            String mapJakcson = mapper.writeValueAsString(swaggerResources);
            servletResponse.getOutputStream().write(mapJakcson.getBytes());
        }

        @Override
        public void destroy() {

        }
    }

}
