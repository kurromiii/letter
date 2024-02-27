package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Person;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.Gender;
import com.mftplus.letter.model.entity.enums.Role;
import com.mftplus.letter.model.service.impl.PersonServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@WebServlet(name = "ProfileServlet" , urlPatterns = "/profile.do")
public class ProfileDTOServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;
    @Inject
    private User user;
    @Inject
    private PersonServiceImpl personService;
    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("genders", Arrays.asList(Gender.values()));
            req.getSession().setAttribute("roles", Arrays.asList(Role.values()));
            req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String family = req.getParameter("family");
            String nationalCode = req.getParameter("nationalCode");
            String gender = req.getParameter("gender");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String role = req.getParameter("role");

            person = Person
                    .builder()
                    .name(name)
                    .family(family)
                    .nationalCode(nationalCode)
                    .gender(Gender.valueOf(gender))
                    .deleted(false)
                    .build();
            personService.save(person);
            log.info("Person Saved");

            user = User
                    .builder()
                    .username(username)
                    .password(password)
                    .role(Role.valueOf(role))
                    .deleted(false)
                    .build();
            userService.save(user);
            log.info("User Saved");
            resp.sendRedirect("/login.do");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
