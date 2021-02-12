package com.project.carrental.controller;

import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import com.project.carrental.service.factory.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CarRentalController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    private CommandFactory commandFactory;

    @GetMapping("/{view}")
    public String viewMapping(@PathVariable String view) {
        return view;
    }
    @RequestMapping(value = { "/CarRentalServlet" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getCommand(@RequestParam(required = false) String command,
                                   HttpServletRequest req, HttpServletResponse res,
                                   HttpSession session) throws ServletException, IOException {
        session.setAttribute("orderList", orderRepository.findAll());
        session.setAttribute("vehicleList", vehicleRepository.findAll());
        return commandFactory.getCommand(command).execute(req, res, session);
    }
}