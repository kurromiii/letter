package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.CompositeKey;
import com.mftplus.letter.model.entity.Roles;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.Role;
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


@Slf4j
//@WebServlet(urlPatterns = "")
public class InitialServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;
    @Inject
    private RolesServiceImpl rolesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            log.info("InitialServlet - Get");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
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
                            .build();
            if (userService.findByUsername("admin").isEmpty()){
            userService.save(user);
            log.info("admin user saved");
            }
            CompositeKey compositeKey =
                    CompositeKey
                            .builder()
                            .roleName("admin")
                            .user(user)
                            .build();
            Roles role =
                    Roles
                            .builder()
                            .compositeKey(compositeKey)
                            .build();
            if (rolesService.findById(compositeKey).isEmpty()){
               rolesService.save(role);
               log.info("admin role saved");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//
//        log.info("start");
//        try {
//            log.info("kos shere sathe bala");
//            User user =
//                    User
//                            .builder()
//                            .username("admin")
//                            .password("admin123")
//                            .build();
//            log.info("part2");
//            UserServiceImpl userService = new UserServiceImpl();
//            log.info("part3");
//            if (userService.findByUsername("admin").isEmpty()) {
//                userService.save(user);
//                log.info("admin user saved");
//            }
//            log.info("part4");
//            CompositeKey compositeKey =
//                    CompositeKey
//                            .builder()
//                            .roleName("admin")
//                            .user(user)
//                            .build();
//            log.info("part5");
//            Roles role =
//                    Roles
//                            .builder()
//                            .compositeKey(compositeKey)
//                            .build();
//            RolesServiceImpl rolesService = new RolesServiceImpl();
//            if (rolesService.findById(compositeKey).isEmpty()) {
//                rolesService.save(role);
//                log.info("admin role saved");
//            }
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            System.out.println(e);
//            throw new RuntimeException(e);
//        }
//        ServletContextListener.super.contextInitialized(sce);
//    }
}
