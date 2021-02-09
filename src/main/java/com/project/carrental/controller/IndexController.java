package com.project.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

//    @RequestMapping(params = {"/", "index"})
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}