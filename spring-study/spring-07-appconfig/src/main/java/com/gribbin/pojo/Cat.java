package com.gribbin.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * @author Gribbin
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    public void destroy() {
        System.out.println("cat destroy...");
    }

    public void afterPropertiesSet() {
        System.out.println("cat afterPropertiesSet...");
    }
}
