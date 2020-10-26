package com.gribbin.pojo;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单实例
    public boolean isSingleton() {
        return false;
    }
}
