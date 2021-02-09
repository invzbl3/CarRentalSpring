package com.project.carrental.controller;

import com.project.carrental.service.factory.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CarRentalController {
    @Autowired
    private CommandFactory commandFactory; //singleton object instance injected to be used/shared by all controllers

    @RequestMapping(value = { "/CarRentalServlet" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String getCommand(@RequestParam("command") String command,
                            HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException { // extract parameter from the request
        return commandFactory.getCommand(command).execute(req, res, session); // return name of the jsp file to render
    }
}