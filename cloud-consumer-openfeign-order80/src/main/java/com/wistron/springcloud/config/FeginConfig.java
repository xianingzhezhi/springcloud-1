package com.wistron.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {

    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
