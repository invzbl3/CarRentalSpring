package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class that represents command to register new user.
 *
 */
@Service
public class RegisterCommand implements ICommand {
    @Autowired
    UserRepository userRepository;

    public static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());

        String login = req.getParameter(REQ_PARAM_LOGIN);
        String password = req.getParameter(REQ_PARAM_PASSWORD);
        String passwordConfirm = req.getParameter(REQ_PARAM_PASSWORD_CONFIRM);

        String page;
        try {
            if (password.equals(passwordConfirm)) {
                //IUserDao userDAO = DaoFactory.getUserDAO();
                //if (userDAO.findByLogin(login) == null) {
                if(userRepository.findByLogin(login) == null) {
                    User user = new User();
                    user.setUserTypeID(LogInCommand.ACC_TYPE_CLIENT);
                    user.setLogin(login);
                    user.setPassword(password);

                    /*int insertUserCode = userDAO.insert(user);
                    if (insertUserCode == DaoHelper.EXECUTE_UPDATE_ERROR_CODE) {
                        throw new IllegalArgumentException("Registration failed. Entry was not created");
                    }*/

                    try {
                        userRepository.save(user);
                    } catch (DataAccessException e) {
                        throw new IllegalArgumentException("Registration failed. Entry was not created");
                    }

                    LOGGER.info(user + " registered successfully");
                    page = ConfigManager.getInstance()
                            .getProperty(ConfigManager.INFO_REG_PAGE_PATH);
                } else {
                    throw new SecurityException("User with such login already exists");
                }
            } else {
                throw new IllegalStateException("Not equal confirmation password");
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error("Registration entry creation error " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_UPDATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalStateException e) {
            LOGGER.error("Password confirmation failed " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, PASSWORD_CONFIRMATION_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (SecurityException e) {
            LOGGER.error("User with such login already exists " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, USER_EXISTS_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return new ModelAndView(page);
    }
}