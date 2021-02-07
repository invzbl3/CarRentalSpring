package com.project.carrental.tags;

import com.project.carrental.dao.daofactory.DaoFactory;
import com.project.carrental.dao.idao.IVehicleDao;
import com.project.carrental.entity.Vehicle;
import com.project.carrental.service.command.ICommand;

import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Defines custom tag that loads vehicle list from database to JSP.
 *
 * @see TagSupport
 */
public class LoadVehicleListTag extends TagSupport {

    /**
     * Loads vehicle list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        IVehicleDao vehicleDAO = DaoFactory.getVehicleDAO();
        List<Vehicle> vehicleList = vehicleDAO.findAll();
        pageContext.setAttribute(ICommand.REQ_PARAM_VEHICLE_LIST, vehicleList);
        return SKIP_BODY;
    }
}