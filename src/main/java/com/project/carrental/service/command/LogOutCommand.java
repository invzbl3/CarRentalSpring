package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.repository.VehicleRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class that represents command to log out.
 */


@Service
public class LogOutCommand implements ICommand {
    public static final Logger LOGGER = Logger.getLogger(LogOutCommand.class);

    final OrderRepository orderRepository;
    final VehicleRepository vehicleRepository;

    public LogOutCommand(OrderRepository orderRepository, VehicleRepository vehicleRepository) {
        this.orderRepository = orderRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());

        session.removeAttribute(SESS_PARAM_USER_NAME);
        session.removeAttribute(SESS_PARAM_USERTYPE_ID);

        session.removeAttribute(SESS_PARAM_USER_NAME);
        session.removeAttribute(SESS_PARAM_USERTYPE_ID);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("orderList", orderRepository.findAll());
        modelAndView.addObject("vehicleList", vehicleRepository.findAll());
        return new ModelAndView(ConfigManager.getInstance()
                .getProperty(ConfigManager.INDEX_PAGE_PATH));
    }
}
