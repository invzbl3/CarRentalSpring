package com.project.carrental.controller;

import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    VehicleRepository vehicleRepository;

//    @GetMapping("/")
    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("orderList", orderRepository.findAll());
        model.addAttribute("vehicleList", vehicleRepository.findAll());
        return "index";
    }
}
