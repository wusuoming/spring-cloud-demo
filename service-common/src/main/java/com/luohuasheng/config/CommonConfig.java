package com.luohuasheng.config;

import com.luohuasheng.controller.CommonController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panda
 */
@Configuration
public class CommonConfig {
    @Bean
    public CommonController client() {
        return new CommonController();
    }

}
