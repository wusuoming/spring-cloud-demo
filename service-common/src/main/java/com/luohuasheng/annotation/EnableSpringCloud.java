package com.luohuasheng.annotation;

import com.luohuasheng.config.CommonConfig;
import com.luohuasheng.config.SpringCloudConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@EnableI18n
@Import({CommonConfig.class, SpringCloudConfig.class})
public @interface EnableSpringCloud {

}
