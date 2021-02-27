package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.entity.Order;
import com.project.carrental.entity.Passport;
import com.project.carrental.entity.User;
import com.project.carrental.entity.Vehicle;
import com.project.carrental.exception.SessionTimeoutException;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.PassportRepository;
import com.project.carrental.repository.UserRepository;
import com.project.carrental.repository.VehicleRepository;
import com.project.carrental.util.CommandHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Class that represents command to add information about new order to database.
 *
 */
@Service
public class CreateOrderCommand implements ICommand {
    final PassportRepository passportRepository;
    final OrderRepository orderRepository;
    final VehicleRepository vehicleRepository;
    final UserRepository userRepository;

    public static final Logger LOGGER = Logger.getLogger(CreateOrderCommand.class);

    public CreateOrderCommand(PassportRepository passportRepository, OrderRepository orderRepository, VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.passportRepository = passportRepository;
        this.orderRepository = orderRepository;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            //create and insert new passport
            Passport passport = new Passport();
            passport.setLastName(req.getParameter(REQ_PARAM_LAST_NAME));
            passport.setFirstName(req.getParameter(REQ_PARAM_FIRST_NAME));
            passport.setPatronymic(req.getParameter(REQ_PARAM_PATRONYMIC));
            passport.setBirthday(Date.valueOf(req.getParameter(REQ_PARAM_BIRTHDAY)));
            passport.setPassportSeries(req.getParameter(REQ_PARAM_P_SERIES));
            passport.setPassportNumber(req.getParameter(REQ_PARAM_P_NUMBER));
            passport.setWhoIssued(req.getParameter(REQ_PARAM_WHO_ISSUED));
            passport.setWhenIssued(Date.valueOf(req.getParameter(REQ_PARAM_WHEN_ISSUED)));

            try {
                passportRepository.save(passport);
            } catch (DataAccessException e) {
                throw new IllegalArgumentException("Passport entry in DB was not created");
            }

            //create and insert new order
            Order order = new Order();
            int vehicleID = Integer.parseInt(req.getParameter(REQ_PARAM_VEHICLE_ID));
            Vehicle vehicle = vehicleRepository.getOne(vehicleID);
            order.setVehicle(vehicle);
            int userID = (Integer) session.getAttribute(SESS_PARAM_USER_ID);
            User user = userRepository.getOne(userID);
            order.setUser(user);
            order.setPassport(passport);
            order.setPickUpDate(Timestamp.valueOf(CalculateCostCommand
                    .convertDateFormat(req
                            .getParameter(REQ_PARAM_PICK_UP_DATE))));
            order.setDropOffDate(Timestamp.valueOf(CalculateCostCommand
                    .convertDateFormat(req
                            .getParameter(REQ_PARAM_DROP_OFF_DATE))));
            order.setRentCost(BigDecimal.valueOf((Double.parseDouble(req.
                    getParameter(REQ_PARAM_RENT_COST)))));

            try {
                orderRepository.save(order);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.INFO_ORDER_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            LOGGER.error("session timed out: " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error while creating order " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_CREATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return new ModelAndView(page);
    }
}