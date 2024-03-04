package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginServlet - Get");
        try {
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginServlet - Post");
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (userService.findByUsernameAndPassword(username, password).isPresent()){
                log.info("User Logged in");
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("/letter.do");
                req.getSession().removeAttribute("wrongUser");
            }else{
                resp.sendRedirect("/login.do");
                String e = "Wrong Username or Password";
                req.getSession().setAttribute("wrongUser",e);
//                throw new AccessDeniedException("Cant Login");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
