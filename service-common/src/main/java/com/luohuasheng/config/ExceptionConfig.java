package com.luohuasheng.config;

import com.luohuasheng.exception.BaseExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfig {
    @Bean
    public BaseExceptionHandler baseExceptionHandler() {
        return new BaseExceptionHandler();
    }
}
