package com.project.carrental.servlet;

import com.project.carrental.service.command.ICommand;
import com.project.carrental.service.factory.CommandFactory;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Application's main servlet
 *
 */

public class CarRentalServlet extends HttpServlet {

    @Autowired
    private CommandFactory COMMAND_FACTORY;
    private boolean flag = true;

    /*public CarRentalServlet(CommandFactory command_factory) {
        COMMAND_FACTORY = command_factory;
    }*/

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session;
        if (flag) {
            session = req.getSession();
//            session.setMaxInactiveInterval(SESSION_TIMEOUT);
            flag = false;
        } else {
            session = req.getSession(false);
        }
        ICommand command = COMMAND_FACTORY.getCommand(req);
        String page = command.execute(req, res, session);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(page);
        dispatcher.forward(req, res);
    }*/

    @GetMapping
    public void processRequest(@RequestParam("command") String command, HttpServletRequest req,
                               HttpServletResponse res) throws ServletException, IOException {
        HttpSession session;
        if (flag) {
            session = req.getSession();
            flag = false;
        } else {
            session = req.getSession(false);
        }
        ICommand iCommand = COMMAND_FACTORY.getCommand(command);

        String page = iCommand.execute(req, res, session);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(page);
        dispatcher.forward(req, res);
    }

    /**
     * Overriden method for loading Log4j logger properties during servlet
     * initialisation
     */
    @Override
    public void init() {
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("/");
        System.setProperty("rootPath", realPath);
        String file = getInitParameter("log4j-init-file");
        if (file != null) {
            PropertyConfigurator.configure(realPath + file);
            System.out.println("Log4J logging started: " + realPath + file);
        } else {
            System.out.println("Log4J init error: " + realPath + file);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}