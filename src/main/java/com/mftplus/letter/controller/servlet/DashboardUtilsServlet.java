package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.controller.session.SessionListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/dashboardUtils.do")
@Slf4j
public class DashboardUtilsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("DashBoardUtilsServlet - Get");
        try {
            req.getSession().setAttribute("online",SessionListener.getOnline());
            req.getSession().setAttribute("visited",SessionListener.getVisited());

            req.getRequestDispatcher("/jsp/dashboard-utils.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
