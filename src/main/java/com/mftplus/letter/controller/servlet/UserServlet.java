package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.controller.validation.BeanValidator;
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

@Slf4j
@WebServlet(name = "UserServlet" , urlPatterns = "/user.do")

public class UserServlet extends HttpServlet {

    @Inject
    private UserServiceImpl userService;
    @Inject
    private RolesServiceImpl rolesService;
    @Inject
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("UserServlet - Get");
        try {
            req.getSession().setAttribute("userList", rolesService.findAll());
            req.getRequestDispatcher("/jsp/form/save/user-form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("User - Get : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("UserServlet - Post");
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            //build user
            user = User
                    .builder()
                    .username(username)
                    .password(password)
                    .deleted(false)
                    .build();

            //validate user
            BeanValidator<User> validator = new BeanValidator<>();

            if (validator.validate(user) != null){
                resp.setStatus(500);
                resp.getWriter().write(validator.validate(user).toString());
            }

            //check for duplicate username
            if (userService.findByUsername(username).isEmpty()){

                //save user
                userService.save(user);

                //save person for user
//                Person person =
//                        Person
//                                .builder()
//                                        .name("null")
//                                        .family("null")
//                                        .nationalCode("0000000000")
//                                        .user(user)
//                                        .deleted(false)
//                                        .build();
//
//
//                personService.save(person);
//                user.setPerson(person);

                //build role for user
                Roles userRole =
                        Roles
                                .builder()
                                .user(user)
                                .role("user")
                                .deleted(false)
                                .build();
                if (rolesService.findByUsernameAndRoleName(user.getUsername(),"user").isEmpty()){
                    rolesService.save(userRole);
                    log.info("new user role saved");
                }

//                List<Roles> rolesList = new ArrayList<>();
//                rolesList.add(rolesService.findById(userRole.getId()).get());
//                user.setRoleList(rolesList);
//
//                userService.edit(user);

                resp.sendRedirect("/user.do");
                req.getSession().removeAttribute("duplicateUsername");

            }else {
                resp.sendRedirect("/user.do");
                String e = "نام کاربری تکراری است !";
                req.getSession().setAttribute("duplicateUsername",e);
            }
        }
        catch (Exception e){
            log.error("User - POST : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}