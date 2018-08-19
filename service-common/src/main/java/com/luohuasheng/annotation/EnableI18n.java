package com.luohuasheng.annotation;

import com.luohuasheng.config.I18nConfig;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableZuulProxy
@Import({I18nConfig.class})
public @interface EnableI18n {

}
