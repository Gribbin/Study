package com.gribbin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author gui.bin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    /**
     *使用@Value赋值
     *1、基本类型
     *2、可以写SpEL,#{}
     *3、可以写${},取出配置文件中的值(在运行环境变量中的值)
     */
    @Value("${person.nickName}")
    private String name;

    @Value("#{20-2}")
    private int age;
}
