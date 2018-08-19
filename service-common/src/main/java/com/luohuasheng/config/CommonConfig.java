package com.luohuasheng.config;

import com.luohuasheng.controller.ClientController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panda
 */
@Configuration
public class CommonConfig {
    @Bean
    public ClientController client() {
        return new ClientController();
    }
}
