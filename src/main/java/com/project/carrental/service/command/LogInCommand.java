/*
package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

*/
/**
 * Class that represents command to log in.
 *
 *//*

@Service
public class LogInCommand implements ICommand {

    @Autowired
    UserRepository userRepository;

    public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);

    private static final int LOGIN_ERROR = -1;
    private static final int ACC_TYPE_ADMIN = 1;
    static final int ACC_TYPE_CLIENT = 2;

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());

        //get DAO and input data
        //IUserDao userDAO = DaoFactory.getUserDAO();
        String login = req.getParameter(REQ_PARAM_LOGIN);
        String password = req.getParameter(REQ_PARAM_PASSWORD);

        //declare variables
        String page;
        User user;
        int userID;

        //check the login information
        switch (checkLogin(login, password)) {
            case ACC_TYPE_CLIENT:
                session.setAttribute(SESS_PARAM_USER_NAME, login);
                session.setAttribute(SESS_PARAM_USERTYPE_ID, ACC_TYPE_CLIENT);
                //user = userDAO.findByLogin(login);
                user = userRepository.findByLogin(login);
                userID = user.getUserID();
                session.setAttribute(SESS_PARAM_USER_ID, userID);
                page = ConfigManager.getInstance()
                        .getProperty(ConfigManager.INDEX_PAGE_PATH);
                LOGGER.info("User " + user.getLogin() + " logged in");
                break;
            case ACC_TYPE_ADMIN:
                session.setAttribute(SESS_PARAM_USER_NAME, login);
                session.setAttribute(SESS_PARAM_USERTYPE_ID, ACC_TYPE_ADMIN);
                //user = userDAO.findByLogin(login);
                user = userRepository.findByLogin(login);
                userID = user.getUserID();
                session.setAttribute(SESS_PARAM_USER_ID, userID);
                page = ConfigManager.getInstance()
                        .getProperty(ConfigManager.INDEX_PAGE_PATH);
                LOGGER.info("Admin " + user.getLogin() + " logged in");
                break;
            case LOGIN_ERROR:
                req.setAttribute(SESS_PARAM_ERROR_MESSAGE, LOGIN_ERROR_MESSAGE);
                page = ConfigManager.getInstance()
                        .getProperty(ConfigManager.ERROR_PAGE_PATH);
                LOGGER.error(login + " login tryout failed");
                break;
            default:
                page = null;
                break;
        }
        return new ModelAndView(page);
    }

    //auxiliary method for checking the login and password correspondence
    private int checkLogin(String login, String password) {
        LOGGER.debug("checkLogin called");
        //IUserDao userDAO = DaoFactory.getUserDAO();
        //User user = userDAO.findByLogin(login);
        User user = userRepository.findByLogin(login);
        if ((user == null) || !(user.getPassword().equals(password))) {
            return LOGIN_ERROR;
        } else {
            return user.getUserTypeID();
        }
    }
}*/
