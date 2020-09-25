package com.gribbin.demo04;

import com.gribbin.demo02.UserService;
import com.gribbin.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ObjectHandler oh = new ObjectHandler();
        oh.setObject(userService);
        UserService proxy = (UserService) oh.getProxy();
        proxy.query();
    }
}
