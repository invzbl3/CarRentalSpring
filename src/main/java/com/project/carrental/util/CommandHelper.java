package com.project.carrental.util;

import com.project.carrental.exception.SessionTimeoutException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

import static com.project.carrental.service.command.ICommand.SESS_PARAM_USER_NAME;

/**
 * Class contains auxiliary methods for commands package
 *
 */
public class CommandHelper {
    public static final Logger LOGGER = Logger.getLogger(CommandHelper.class);

    /**
     * Method checks if session is still valid, or it has expired.
     *
     * @param session
     * @throws SessionTimeoutException
     */
    public static void validateSession(HttpSession session) throws SessionTimeoutException {
        try {
            LOGGER.info("Validate session called. Session id: " + session.getId());
            session.setAttribute(SESS_PARAM_USER_NAME,
                    session.getAttribute(SESS_PARAM_USER_NAME));
        } catch (NullPointerException e) {
            LOGGER.warn("Session expired");
            throw new SessionTimeoutException(e);
        }
    }
}