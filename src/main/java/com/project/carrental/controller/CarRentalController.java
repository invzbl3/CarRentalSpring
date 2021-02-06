package com.project.carrental.controller;

import com.project.carrental.service.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
//@RequestMapping("/CarRental") // all request starting from / are forwarded to this class
public class CarRentalController {
    @Autowired
    private AdminZoneButtonCommand adminZoneButtonCommand; //singleton object instance injected to be used/shared by all controllers
    @Autowired
    private CalculateCostCommand calculateCostCommand;
    @Autowired
    private ConfirmOrderCommand confirmOrderCommand;
    @Autowired
    private ConfirmPaymentCommand confirmPaymentCommand;
    @Autowired
    private CreateOrderCommand createOrderCommand;
    @Autowired
    private GiveVehicleCommand giveVehicleCommand;
    @Autowired
    private HomeButtonCommand homeButtonCommand;
    @Autowired
    private LoadOrderListCommand loadOrderListCommand;
    @Autowired
    private LogInCommand loginCommand;
    @Autowired
    private LogOutCommand logOutCommand;
    @Autowired
    private MakeOrderButtonCommand makeOrderButtonCommand;
    @Autowired
    private NoCommand noCommand;
    @Autowired
    private RegisterCommand registerCommand;
    @Autowired
    private RejectOrderCommand rejectOrderCommand;
    @Autowired
    private ResetOrderCommand resetOrderCommand;
    @Autowired
    private ReturnDamagedVehicleCommand returnDamagedVehicleCommand;
    @Autowired
    private SelectOrderCommand selectOrderCommand;


    public String adminZone(Model model, HttpServletRequest req, HttpServletResponse res,
                        HttpSession session) throws ServletException, IOException {
        return adminZoneButtonCommand.execute(req, res, session);
    }

    public String calculateCost(Model model, HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        return calculateCostCommand.execute(req, res, session);
    }

    public String confirmOrder(Model model, HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        return confirmOrderCommand.execute(req, res, session);
    }

    public String confirmPayment(Model model, HttpServletRequest req, HttpServletResponse res,
                               HttpSession session) throws ServletException, IOException {
        return confirmPaymentCommand.execute(req, res, session);
    }

    public String createOrder(Model model, HttpServletRequest req, HttpServletResponse res,
                                 HttpSession session) throws ServletException, IOException {
        return createOrderCommand.execute(req, res, session);
    }

    public String homeButton(Model model, HttpServletRequest req, HttpServletResponse res,
                                     HttpSession session) throws ServletException, IOException {
        return homeButtonCommand.execute(req, res, session);
    }

    public String loadOrderList(Model model, HttpServletRequest req, HttpServletResponse res,
                             HttpSession session) throws ServletException, IOException {
        return loadOrderListCommand.execute(req, res, session);
    }

    public String login(Model model, HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        return loginCommand.execute(req, res, session);
    }

    public String logout(Model model, HttpServletRequest req, HttpServletResponse res,
                        HttpSession session) throws ServletException, IOException {
        return logOutCommand.execute(req, res, session);
    }

    public String makeOrder(Model model, HttpServletRequest req, HttpServletResponse res,
                         HttpSession session) throws ServletException, IOException {
        return makeOrderButtonCommand.execute(req, res, session);
    }

    public String none(Model model, HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException {
        return noCommand.execute(req, res, session);
    }

    public String register(Model model, HttpServletRequest req, HttpServletResponse res,
                            HttpSession session) throws ServletException, IOException {
        return registerCommand.execute(req, res, session);
    }

    public String reject(Model model, HttpServletRequest req, HttpServletResponse res,
                           HttpSession session) throws ServletException, IOException {
        return rejectOrderCommand.execute(req, res, session);
    }

    public String reset(Model model, HttpServletRequest req, HttpServletResponse res,
                         HttpSession session) throws ServletException, IOException {
        return resetOrderCommand.execute(req, res, session);
    }

    public String returnDamagedVehicle(Model model, HttpServletRequest req, HttpServletResponse res,
                        HttpSession session) throws ServletException, IOException {
        return returnDamagedVehicleCommand.execute(req, res, session);
    }

    public String selectOrder(Model model, HttpServletRequest req, HttpServletResponse res,
                                       HttpSession session) throws ServletException, IOException {
        return selectOrderCommand.execute(req, res, session);
    }
    
    /*@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET) //this method is called for GET request for /CarRental page
    public String processGetRequest(@RequestParam String command) { // extract parameter from the request
        return "index"; // return name of the jsp file to render
    }
    @PostMapping("/post") // this method is called for POST request for /CarRental/post page
    public String processPostRequest() {
        return "post"; // would render post.jsp page
    }*/

}