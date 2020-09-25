package com.gribbin.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {
    private String name;

    //Autowired通过byType的方式实现，而且要求这个对象必须存在
    //Resource默认通过byName的方式实现，如果找不到名字则通过byType方式实现！两种方式都找不到则报错
    //required = false表示属性可以为null,否则默认不可以为null
    @Autowired(required = false)
    //@Resource
    private Cat cat;

    @Autowired
    @Qualifier(value = "dog11")
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
