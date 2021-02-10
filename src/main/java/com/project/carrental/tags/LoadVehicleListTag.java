package com.project.carrental.tags;

import com.project.carrental.entity.Vehicle;
import com.project.carrental.repository.VehicleRepository;
import com.project.carrental.service.command.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Defines custom tag that loads vehicle list from database to JSP.
 *
 * @see TagSupport
 */
@Configurable
public class LoadVehicleListTag extends TagSupport {

    @Autowired
    VehicleRepository vehicleRepository;

    /**
     * Loads vehicle list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        //IVehicleDao vehicleDAO = DaoFactory.getVehicleDAO();
        //List<Vehicle> vehicleList = vehicleDAO.findAll();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        pageContext.setAttribute(ICommand.REQ_PARAM_VEHICLE_LIST, vehicleList);
        return SKIP_BODY;
    }
}