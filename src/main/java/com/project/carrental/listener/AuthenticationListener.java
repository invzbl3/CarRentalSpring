/*
package com.project.carrental.listener;

import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationListener implements AuthenticationSuccessHandler, LogoutSuccessHandler {

    public static final String USER_ID = "userID";
    private static final String USERNAME = "userName";
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        request.getSession().removeAttribute(USER_ID);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String username = request.getParameter(USERNAME);
        User user = userRepository.findByLogin(username);
        int userID = user.getUserID();
        request.getSession().setAttribute(USER_ID, userID);
    }
}
*/
