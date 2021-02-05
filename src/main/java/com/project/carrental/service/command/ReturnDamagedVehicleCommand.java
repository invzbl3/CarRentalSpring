package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.dao.DaoHelper;
import com.project.carrental.dao.daofactory.DaoFactory;
import com.project.carrental.dao.idao.IOrderDao;
import com.project.carrental.entity.Order;
import com.project.carrental.exception.SessionTimeoutException;
import com.project.carrental.util.CommandHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Class that represents command to make notes in database representing that
 * returned vehicle was damaged.
 *
 */
@Service("returnDamagedVehicle")
public class ReturnDamagedVehicleCommand implements ICommand {

    public static final Logger LOGGER = Logger.getLogger(ReturnDamagedVehicleCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
                          HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            System.out.println(req.getParameter(REQ_PARAM_ORDER_ID));
            System.out.println(req.getParameter(REQ_PARAM_DAMAGE_DESC));
            System.out.println(req.getParameter(REQ_PARAM_DAMAGE_COST));

            IOrderDao orderDAO = DaoFactory.getOrderDAO();
            Order order = orderDAO.findByID(Integer.parseInt(req.
                    getParameter(REQ_PARAM_ORDER_ID)));
            order.setReturned(true);
            order.setDamaged(true);
            order.setDamageDesc(req.getParameter(REQ_PARAM_DAMAGE_DESC));
            BigDecimal damageCost = BigDecimal.valueOf(Double
                    .parseDouble(req.getParameter(REQ_PARAM_DAMAGE_COST)));
            order.setDamageCost(damageCost);
            int updateOrderCode = orderDAO.update(order);
            if (updateOrderCode == DaoHelper.EXECUTE_UPDATE_ERROR_CODE) {
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
        return page;
    }
}