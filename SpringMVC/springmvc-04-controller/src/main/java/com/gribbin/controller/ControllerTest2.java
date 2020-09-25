package com.gribbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表这个类会被spring接管，类中的方法如果返回值是String，并且有具体页面可以跳转，那么就会被视图解析器解析
public class ControllerTest2 {
    @RequestMapping("/t2")
    public String index(Model model) {
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "ControllerTest2");
        //返回视图位置
        return "test";
    }

    @RequestMapping("/t3")
    public String test3(Model model) {
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "Test3");
        //返回视图位置
        return "test";
    }
}
