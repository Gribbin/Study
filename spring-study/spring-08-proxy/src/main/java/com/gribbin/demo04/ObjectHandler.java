package com.gribbin.demo04;

import java.lang.reflect.*;

public class ObjectHandler implements InvocationHandler {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(object, args);
        return result;
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法~~");
    }

}
