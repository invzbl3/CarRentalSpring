package com.project.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

//    @GetMapping("/")
    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
}
