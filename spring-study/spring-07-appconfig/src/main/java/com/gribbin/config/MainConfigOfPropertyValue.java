package com.gribbin.config;

import com.gribbin.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用@PropertySource读取配置文件中的K/V保存到运行的环境变量中
 *
 * @Author gribbin
 * @create 2020/11/2 16:39
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {
    @Bean
    public Person person() {
        return new Person();
    }
}
