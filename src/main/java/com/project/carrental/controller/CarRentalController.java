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

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String processGetRequest(@RequestParam("command") String command) throws ServletException, IOException { // extract parameter from the request
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String adminZone(@RequestParam("command") String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String calculateCost(@RequestParam("command") String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String confirmOrder(@RequestParam("command") String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String confirmPayment(@RequestParam("command") String command,
                               HttpServletRequest req, HttpServletResponse res,
                               HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String createOrder(@RequestParam("command") String command,
                                 HttpServletRequest req, HttpServletResponse res,
                                 HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "info_order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String giveVehicle(@RequestParam("command") String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String homeButton(@RequestParam("command") String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String loadOrderList(@RequestParam("command") String command,
                             HttpServletRequest req, HttpServletResponse res,
                             HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String logIn(@RequestParam("command") String command,
                                HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String logOut(@RequestParam("command") String command,
                        HttpServletRequest req, HttpServletResponse res,
                        HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String makeOrderButton(@RequestParam("command") String command,
                         HttpServletRequest req, HttpServletResponse res,
                         HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "order"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String noCommand(@RequestParam("command") String command,
                                  HttpServletRequest req, HttpServletResponse res,
                                  HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "index"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String registerCommand(@RequestParam("command") String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "info_registration"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String rejectOrder(@RequestParam("command") String command,
                                  HttpServletRequest req, HttpServletResponse res,
                                  HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String resetOrder(@RequestParam("command") String command,
                              HttpServletRequest req, HttpServletResponse res,
                              HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String returnDamagedVehicle(@RequestParam("command") String command,
                             HttpServletRequest req, HttpServletResponse res,
                             HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String returnVehicle(@RequestParam("command") String command,
                                       HttpServletRequest req, HttpServletResponse res,
                                       HttpSession session) throws ServletException, IOException { // extract parameter from the request
        commandFactory.getCommand(command).execute(req, res, session);
        return "admin"; // return name of the jsp file to render
    }

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    @ResponseBody
    public String selectOrder(@RequestParam("command") String command,
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