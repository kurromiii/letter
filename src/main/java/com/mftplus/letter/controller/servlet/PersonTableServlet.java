package com.mftplus.letter.controller.servlet;

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
@WebServlet(urlPatterns = "/personTable.do")
public class PersonTableServlet extends HttpServlet {
    @Inject
    private PersonServiceImpl personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PersonTableServlet - Get");
        try {
            req.getSession().setAttribute("personList", personService.findAll());
            req.getRequestDispatcher("/jsp/table/person.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
