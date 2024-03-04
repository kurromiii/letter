package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Organisation;
import com.mftplus.letter.model.service.impl.OrganisationServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/organisation.do")
@Slf4j
public class OrganisationServlet extends HttpServlet {
    @Inject
    private OrganisationServiceImpl service;

    @Inject
    private Organisation organisation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("OrganizationServlet - Get");
        try {
            req.getSession().setAttribute("organisationList", service.findAll());
            req.getRequestDispatcher("/jsp/organisation.jsp").forward(req, resp);
            service.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("OrganizationServlet - Post");
        try {
            String title = req.getParameter("title");
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            String description = req.getParameter("description");

            organisation = Organisation
                    .builder()
                    .name(name)
                    .title(title)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .description(description)
                    .deleted(false)
                    .build();

            service.save(organisation);
            log.info("Organisation Saved");
            resp.sendRedirect("/person.do");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}

