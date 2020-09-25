package com.gribbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ModelTest1");
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "ModelTest1");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test3(Model model) {
        model.addAttribute("msg", "ModelTest1");
        return "redirect:/index.jsp";
    }
}
