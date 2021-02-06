package com.project.carrental.controller;

import com.project.carrental.service.command.*;
import com.project.carrental.service.factory.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
//@RequestMapping("/CarRental") // all request starting from / are forwarded to this class
public class CarRentalController {
    @Autowired
    private CommandFactory commandFactory; //singleton object instance injected to be used/shared by all controllers

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String processGetRequest(@RequestParam String command) throws ServletException, IOException { // extract parameter from the request
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String adminZone(@RequestParam String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/order" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String calculateCost(@RequestParam String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String confirmOrder(@RequestParam String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String confirmPayment(@RequestParam String command,
                               HttpServletRequest req, HttpServletResponse res,
                               HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/info_order" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String createOrder(@RequestParam String command,
                                 HttpServletRequest req, HttpServletResponse res,
                                 HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "info_order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String giveVehicle(@RequestParam String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String homeButton(@RequestParam String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String loadOrderList(@RequestParam String command,
                             HttpServletRequest req, HttpServletResponse res,
                             HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String logIn(@RequestParam String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String logOut(@RequestParam String command,
                        HttpServletRequest req, HttpServletResponse res,
                        HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/order" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String makeOrderButton(@RequestParam String command,
                         HttpServletRequest req, HttpServletResponse res,
                         HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String noCommand(@RequestParam String command,
                                  HttpServletRequest req, HttpServletResponse res,
                                  HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/info_registration" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String registerCommand(@RequestParam String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "info_registration"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String rejectOrder(@RequestParam String command,
                                  HttpServletRequest req, HttpServletResponse res,
                                  HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String resetOrder(@RequestParam String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String returnDamagedVehicle(@RequestParam String command,
                             HttpServletRequest req, HttpServletResponse res,
                             HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String returnVehicle(@RequestParam String command,
                                       HttpServletRequest req, HttpServletResponse res,
                                       HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String selectOrder(@RequestParam String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    /*@PostMapping("/post") // this method is called for POST request for /CarRental/post page
    public String processPostRequest() {
        return "post"; // would render post.jsp page
    }*/
}