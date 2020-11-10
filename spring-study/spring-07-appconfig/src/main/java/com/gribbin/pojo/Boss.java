package com.gribbin.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author gribbin
 * @create 2020/11/10 17:22
 */
public class Boss {
    private Car car;

    public Boss(@Autowired Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
