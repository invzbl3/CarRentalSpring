package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.entity.Order;
import com.project.carrental.exception.SessionTimeoutException;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.util.CommandHelper;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class that represents command to represent in database that order has been
 * rejected.
 *
 */
@Service
public class RejectOrderCommand implements ICommand {

    final OrderRepository orderRepository;

    public static final Logger LOGGER = Logger.getLogger(RejectOrderCommand.class);

    public RejectOrderCommand(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            Order order = orderRepository.getOne(Integer.parseInt(req.
                    getParameter(REQ_PARAM_ORDER_ID)));
            order.setProcessed(true);
            order.setRejected(true);
            order.setRejectDesc(req.getParameter(REQ_PARAM_REJECT_DESC));

            try {
                orderRepository.save(order);
            } catch (DataAccessException e) {
                throw new IllegalArgumentException("Order entry in DB was not updated");
            }

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ADMIN_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error while updating order " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_UPDATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return new ModelAndView(page);
    }
}