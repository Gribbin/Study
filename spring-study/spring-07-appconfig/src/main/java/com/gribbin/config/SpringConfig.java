package com.gribbin.config;

import com.gribbin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.gribbin")
public class SpringConfig {
    @Bean
    public User user(){
        return new User();
    }
}
