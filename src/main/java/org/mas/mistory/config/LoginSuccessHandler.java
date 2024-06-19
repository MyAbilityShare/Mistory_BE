package org.mas.mistory.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // HttpSession session = request.getSession();
        // session.setAttribute("username", authentication.getName());
        // response.sendRedirect("http://127.0.0.1:5500/Mistory_FE/Mistory/ranking.html");
        response.sendRedirect("http://127.0.0.1:5501/Mistory/ranking.html");
    }
}