package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.RolesPrimaryKeys;
import com.mftplus.letter.model.entity.Roles;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.service.impl.RolesServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class InitialServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;
    @Inject
    private RolesServiceImpl rolesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            log.info("InitialServlet - Get");
            req.getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

   @Override
    public void init() throws ServletException {
        log.info("InitialServlet - Init");
        super.init();
        try {
            User user =
                    User
                            .builder()
                            .username("admin")
                            .password("admin123")
                            .deleted(false)
                            .build();
            if (userService.findByUsername("admin").isEmpty()){
            userService.save(user);
            log.info("admin username saved");
            }
            RolesPrimaryKeys rolesPrimaryKeys =
                    RolesPrimaryKeys
                            .builder()
                            .roleName("admin")
                            .user(user)
                            .build();
            Roles role =
                    Roles
                            .builder()
                            .rolesPrimaryKeys(rolesPrimaryKeys)
                            .deleted(false)
                            .build();
            if (rolesService.findById(rolesPrimaryKeys).isEmpty()){
               rolesService.save(role);
               log.info("admin role saved");
            }

            User user1 =
                    User
                            .builder()
                            .username("user")
                            .password("user123")
                            .deleted(false)
                            .build();
            if (userService.findByUsername("user").isEmpty()){
                userService.save(user1);
                log.info("user username saved");
            }
            RolesPrimaryKeys rolesPrimaryKeys1 =
                    RolesPrimaryKeys
                            .builder()
                            .roleName("user")
                            .user(user1)
                            .build();
            Roles role1 =
                    Roles
                            .builder()
                            .rolesPrimaryKeys(rolesPrimaryKeys1)
                            .deleted(false)
                            .build();
            if (rolesService.findById(rolesPrimaryKeys1).isEmpty()){
                rolesService.save(role1);
                log.info("user role saved");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
