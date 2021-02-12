/*
package com.project.carrental.tags;

import com.project.carrental.entity.Order;
import com.project.carrental.repository.OrderRepository;
import com.project.carrental.service.command.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

*/
/**
 * Defines custom tag that loads order list from database to JSP.
 *
 * @see TagSupport
 *//*

public class LoadOrderListTag extends TagSupport {

    @Autowired
    OrderRepository orderRepository;

    */
/**
     * Loads order list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     *//*

    @Override
    public int doStartTag() throws JspException {
        //IOrderDao orderDAO = DaoFactory.getOrderDAO();
        //List<Order> orders = orderDAO.findAll();
        List<Order> orders = orderRepository.findAll();
        pageContext.setAttribute(ICommand.REQ_PARAM_ORDER_LIST, orders);
        return SKIP_BODY;
    }
}*/
