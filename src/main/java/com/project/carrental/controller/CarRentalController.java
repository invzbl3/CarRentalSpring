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
public class CarRentalController {
    @Autowired
    private CommandFactory commandFactory; //singleton object instance injected to be used/shared by all controllers

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String processGetRequest(@RequestParam("command") String command) throws ServletException, IOException { // extract parameter from the request
        return "index"; // return name of the jsp file to render
    }

    /*@PostMapping("/post") // this method is called for POST request for /CarRental/post page
    public String processPostRequest() {
        return "post"; // would render post.jsp page
    }*/

    @RequestMapping(value = { "/CarRentalServlet" }, method = RequestMethod.GET)
    public String getCommand(@RequestParam("command") String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        return commandFactory.getCommand(command).execute(req, res, session); // return name of the jsp file to render
    }
}