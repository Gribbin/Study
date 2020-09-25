package com.gribbin.controller;

import com.gribbin.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void ajax1(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> ajax2() {
        List<User> list = new ArrayList<User>();
        list.add(new User("秦疆1号", 17, "男"));
        list.add(new User("秦疆2号", 18, "女"));
        list.add(new User("秦疆3号", 19, "男"));
        return list; //由于@RestController注解，将list转成json格式返回
    }

    @RequestMapping("/a3")
    public String ajax3(String name, String pwd) {
        String msg = "";
        if (null != name) {
            if ("admin".equals(name)) {
                msg = "OK";
            } else {
                msg = "用户名错误";
            }
        }

        if (null != pwd) {
            if ("123456".equals(pwd)) {
                msg = "OK";
            } else {
                msg = "密码错误";
            }
        }

        return msg;
    }
}
