package com.luohuasheng.annotation;

import com.luohuasheng.config.Swagger2Config;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({Swagger2Config.class})
public @interface EnableSwagger2 {

}
