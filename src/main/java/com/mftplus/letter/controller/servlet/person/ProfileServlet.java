package com.mftplus.letter.controller.servlet.person;

import com.mftplus.letter.model.service.impl.PersonServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/profile.do")
public class ProfileServlet extends HttpServlet {

    @Inject
    private PersonServiceImpl personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ProfileServlet - Get");
        try {
            String username = req.getUserPrincipal().getName();

            req.getSession().setAttribute("principalUser", username);
            req.getSession().setAttribute("person", personService.findByUsername(username).get());
            req.getRequestDispatcher("/jsp/form/display/profile.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
