package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Roles;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.service.impl.RolesServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Slf4j
public class LoginServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;
    @Inject
    private RolesServiceImpl rolesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginServlet - Get");
        try {
            if (req.getUserPrincipal() != null){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.do");
                dispatcher.forward(req,resp);
            }
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        log.info("LoginServlet - Init");
        super.init();
        try {
            User admin =
                    User
                            .builder()
                            .username("admin")
                            .password("admin123")
                            .deleted(false)
                            .build();
            if (userService.findByUsername("admin").isEmpty()){
                userService.save(admin);
                log.info("admin username saved");
            }
            Roles adminRole =
                    Roles
                            .builder()
                            .user(admin)
                            .role("admin")
                            .deleted(false)
                            .build();
            if (rolesService.findByUsernameAndRoleName("admin","admin").isEmpty()){
                System.out.println(adminRole);
                rolesService.save(adminRole);
                log.info("admin role saved");
            }

            User user =
                    User
                            .builder()
                            .username("user")
                            .password("user123")
                            .deleted(false)
                            .build();
            if (userService.findByUsername("user").isEmpty()){
                userService.save(user);
                log.info("user username saved");
            }
            Roles userRole =
                    Roles
                            .builder()
                            .user(user)
                            .role("user")
                            .deleted(false)
                            .build();
            if (rolesService.findByUsernameAndRoleName("user","user").isEmpty()){
                rolesService.save(userRole);
                log.info("user role saved");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("username",req.getParameter("username"));
        session.setAttribute("password",req.getParameter("password"));
            resp.sendRedirect(resp.encodeRedirectURL("/home.do"));
    }
}
