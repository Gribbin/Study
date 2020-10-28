package com.gribbin.pojo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author gribbin
 * @create 2020/10/27 16:57
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog PostConstruct...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog PreDestroy...");
    }
}
