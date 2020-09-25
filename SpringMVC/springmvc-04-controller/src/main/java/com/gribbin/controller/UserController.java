package com.gribbin.controller;

import com.gribbin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/user/t1")
    public String userTest1(@RequestParam("username") String name, ModelMap model) {
        //封装要显示到视图中的数据
        //Model、ModelMap和ModelAndView3种处理数据方式
        model.addAttribute("name",name);
        System.out.println(name);
        return "test";
    }

    @GetMapping("/user")
    public String userTest2(User user) {
        System.out.println(user);
        return "test";
    }
}
