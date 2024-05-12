package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Roles;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.service.impl.RolesServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/roles.do")
public class RolesServlet extends HttpServlet {
    @Inject
    private RolesServiceImpl rolesService;
    @Inject
    private UserServiceImpl userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("RolesServlet - Get");

        try {
            //todo
//            req.getSession().setAttribute("roleTypes", Arrays.asList(Role.values()));
            req.getSession().setAttribute("rolesList", rolesService.findAll());
            req.getRequestDispatcher("/jsp/form/roles-form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo : can not save
        log.info("RolesServlet - Post");
        try {
            String roleName = req.getParameter("role");
            String username = req.getParameter("user");
            System.out.println(roleName);
            System.out.println(username);

            if (username != null){
                Optional<User> user = userService.findByUsername(username);

                if (user.isPresent()){
                    Roles role =
                            Roles
                                    .builder()
                                    .user(user.get())
                                    .role(roleName)
                                    .build();
                    rolesService.save(role);
                    log.info("RolesServlet - role saved");
                    resp.sendRedirect("/roles.do");
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
