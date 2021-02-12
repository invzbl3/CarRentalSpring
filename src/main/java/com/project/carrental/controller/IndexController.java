package com.project.carrental.controller;

import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    VehicleRepository vehicleRepository;

//    @GetMapping("/")
    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        /*model.addAttribute("orderList", orderRepository.findAll());
        model.addAttribute("vehicleList", vehicleRepository.findAll());
        return "index";*/
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("orderList", orderRepository.findAll());
        modelAndView.addObject("vehicleList", vehicleRepository.findAll());
        return modelAndView;
    }
}
