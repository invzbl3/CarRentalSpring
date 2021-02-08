package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.exception.SessionTimeoutException;
import com.project.carrental.repository.VehicleRepository;
import com.project.carrental.util.CommandHelper;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Class that represents command to calculate the rent cost for specified
 * vehicle and dates.
 *
 */
@Service("calculateCost")
public class CalculateCostCommand implements ICommand {
    @Autowired
    VehicleRepository vehicleRepository;

    public static final Logger LOGGER = Logger.getLogger(CalculateCostCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
                          HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            int vehicleID = Integer.parseInt(req.getParameter(REQ_PARAM_VEHICLE_CHOICE));
            req.setAttribute(REQ_PARAM_VEHICLE_ID, vehicleID);

            String tmpPick = req.getParameter(REQ_PARAM_PICK_UP_DATE);
            String tmpDrop = req.getParameter(REQ_PARAM_DROP_OFF_DATE);
            Timestamp pick = Timestamp.valueOf(convertDateFormat(tmpPick));
            Timestamp drop = Timestamp.valueOf(convertDateFormat(tmpDrop));
            req.setAttribute(REQ_PARAM_PICK_UP_DATE, tmpPick);
            req.setAttribute(REQ_PARAM_DROP_OFF_DATE, tmpDrop);

            //IVehicleDao vehicleDAO = DaoFactory.getVehicleDAO();
            int rentInterval = daysBetween(pick, drop);
            //BigDecimal dailyPrice = vehicleDAO.findDailyPriceByVehicleID(vehicleID);
            //BigDecimal dailyPrice = vehicleRepository.getDailyPriceByVehicleID(vehicleID);
            BigDecimal dailyPrice = vehicleRepository.getOne(vehicleID).getDailyPrice();
            BigDecimal rentCost = calcRentCost(dailyPrice, rentInterval);
            req.setAttribute(REQ_PARAM_RENT_COST, rentCost);

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ORDER_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            LOGGER.error("session timed out: " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return page;
    }

    //auxiliary method for counting number of days between two Timestamp objects
    private int daysBetween(Timestamp ts1, Timestamp ts2) {
        DateTime firstDateTime;
        DateTime secondDateTime;
        if (ts2.after(ts1)) {
            firstDateTime = new DateTime(ts1.getTime());
            secondDateTime = new DateTime(ts2.getTime());
        } else {
            LOGGER.warn("Second parameter date is before first");
            firstDateTime = new DateTime(ts2.getTime());
            secondDateTime = new DateTime(ts1.getTime());
        }
        return Days.daysBetween(firstDateTime.withTimeAtStartOfDay(),
                secondDateTime.withTimeAtStartOfDay()).getDays();
    }

    //auxiliary method for calculating rent cost based on daily price and number
    //of days
    private BigDecimal calcRentCost(BigDecimal dailyPrice, int days) {
        return dailyPrice.multiply(new BigDecimal(days));
    }

    //auxiliary method for converting date format from HTML to Java
    static String convertDateFormat(String htmlDate) {
        String[] separateDateTime = htmlDate.split("T");
        return separateDateTime[0] +
                " " +
                separateDateTime[1] +
                ":00";
    }
}