package com.project.carrental.service.command;

import com.project.carrental.config.ConfigManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class that represents a command with no parameter that forwards user to index
 * page.
 *
 */
@Service
public class NoCommand implements ICommand {

    public static final Logger LOGGER = Logger.getLogger(NoCommand.class);

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res,
                                HttpSession session) throws ServletException, IOException {
        LOGGER.info("Command called: " + this.getClass().getSimpleName());
        /*return ConfigManager.getInstance()
                .getProperty(ConfigManager.INDEX_PAGE_PATH);*/
        return new ModelAndView(ConfigManager.getInstance()
                .getProperty(ConfigManager.INDEX_PAGE_PATH));
    }
}