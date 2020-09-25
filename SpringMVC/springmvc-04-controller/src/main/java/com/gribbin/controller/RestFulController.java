package com.gribbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {
    //带参数URLhttp://localhost:8080/04/add？a=1&b=2
    //RestFul风格http://localhost:8080/04/add/1/2
    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    //@GetMapping("/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable String b, Model model) {
        String result = a + b;
        model.addAttribute("msg", "结果：" + result);
        return "test";
    }
}
