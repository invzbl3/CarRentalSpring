package com.project.carrental.tags;

import com.project.carrental.dao.daofactory.DaoFactory;
import com.project.carrental.dao.idao.IOrderDao;
import com.project.carrental.entity.Order;
import com.project.carrental.service.command.ICommand;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * Defines custom tag that loads order list from database to JSP.
 *
 * @see TagSupport
 */
public class LoadOrderListTag extends TagSupport {

    /**
     * Loads order list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        IOrderDao orderDAO = DaoFactory.getOrderDAO();
        List<Order> orders = orderDAO.findAll();
        pageContext.setAttribute(ICommand.REQ_PARAM_ORDER_LIST, orders);
        return SKIP_BODY;
    }
}