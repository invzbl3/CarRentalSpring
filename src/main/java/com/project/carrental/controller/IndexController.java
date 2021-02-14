package com.project.carrental.controller;

import com.project.carrental.entity.Vehicle;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(method = RequestMethod.GET)
    public String listVehicles(
            Model model,
            @RequestParam(value = "index", required = false, defaultValue = "0") Integer page
    ) {
        Page<Vehicle> vehiclePage = vehicleRepository.findAll(new PageRequest(page, 2, new Sort(Sort.Direction.DESC, "dailyPrice")));
        /*model.addAttribute("vehiclesPage", vehiclePage);
        model.addAttribute("vehicles", IntStream.range(0, vehiclePage.getTotalPages()).toArray());*/
        model.addAttribute("number", vehiclePage.getNumber());
        model.addAttribute("totalPages", vehiclePage.getTotalPages());
        model.addAttribute("totalElements", vehiclePage.getTotalElements());
        model.addAttribute("size", vehiclePage.getSize());
        model.addAttribute("data",vehiclePage.getContent());
        return "index";
    }
}
