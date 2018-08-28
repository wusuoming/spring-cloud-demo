package com.luohuasheng.annotation;

import com.luohuasheng.config.Swagger2Config;
import com.luohuasheng.config.SwaggerInfoConfig;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerInfoConfig.class, Swagger2Config.class})
public @interface EnableSwagger2 {

    String resourcePackage() default "";

    String title() default "";

    String version() default "";

    String description() default "";
}
