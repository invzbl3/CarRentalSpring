package com.project.carrental.controller;

import com.project.carrental.entity.Vehicle;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import com.project.carrental.service.factory.CommandFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    final OrderRepository orderRepository;
    final VehicleRepository vehicleRepository;
    private final CommandFactory commandFactory;

    public CarRentalController(OrderRepository orderRepository, VehicleRepository vehicleRepository, CommandFactory commandFactory) {
        this.orderRepository = orderRepository;
        this.vehicleRepository = vehicleRepository;
        this.commandFactory = commandFactory;
    }

    @GetMapping("/{view}")
    public String viewMapping(@PathVariable String view) {
        return view;
    }
    @RequestMapping(value = { "/CarRentalServlet" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getCommand(@RequestParam(required = false) String command,
                                   HttpServletRequest req, HttpServletResponse res,
                                   HttpSession session,
    @RequestParam(value = "page", required = false, defaultValue = "0") Integer page
    ) throws ServletException, IOException {

        Page<Vehicle> vehiclePage = vehicleRepository.findAll(new PageRequest(page, 2, new Sort(Sort.Direction.DESC, "dailyPrice")));

        session.setAttribute("number", vehiclePage.getNumber());
        session.setAttribute("totalPages", vehiclePage.getTotalPages());
        session.setAttribute("totalElements", vehiclePage.getTotalElements());
        session.setAttribute("size", vehiclePage.getSize());
        session.setAttribute("data",vehiclePage.getContent());

        session.setAttribute("orderList", orderRepository.findAll());
        session.setAttribute("vehicleList", vehicleRepository.findAll());
        return commandFactory.getCommand(command).execute(req, res, session);
    }
}