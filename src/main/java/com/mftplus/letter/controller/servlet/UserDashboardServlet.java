package com.mftplus.letter.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/userDashboard.do")
@Slf4j
public class UserDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("UserDashBoardServlet - Get");
        try {
            req.getRequestDispatcher("/jsp/user-dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
