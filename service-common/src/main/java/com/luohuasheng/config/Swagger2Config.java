package com.luohuasheng.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author panda
 */
@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi(@Autowired SwaggerInfo swaggerInfo) {
        if (StringUtils.isEmpty(swaggerInfo.getResourcePackage())) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo(swaggerInfo))
                    .select()
                    .build();
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo(swaggerInfo))
                    .select()
                    .apis(Predicates.or(RequestHandlerSelectors.basePackage(swaggerInfo.getResourcePackage())))
                    .paths(PathSelectors.any())
                    .build();
        }

    }

    private ApiInfo apiInfo(SwaggerInfo swaggerInfo) {
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .version(swaggerInfo.getVersion())
                .description(swaggerInfo.getDescription())
                .build();
    }
}