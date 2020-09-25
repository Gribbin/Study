package com.gribbin.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value("大秦")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
