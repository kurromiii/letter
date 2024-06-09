package com.mftplus.letter.controller.servlet.person;

import com.mftplus.letter.controller.validation.BeanValidator;
import com.mftplus.letter.model.entity.Person;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.Gender;
import com.mftplus.letter.model.service.impl.PersonServiceImpl;
import com.mftplus.letter.model.service.impl.RolesServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/person.do")
public class PersonServlet extends HttpServlet {

    @Inject
    private UserServiceImpl userService;

    @Inject
    private RolesServiceImpl rolesService;

    @Inject
    private PersonServiceImpl personService;

    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ProfileEditServlet - Get");
        try {
            String username = req.getUserPrincipal().getName();
            if (personService.findByUsername(username).isPresent()){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.do");
                dispatcher.forward(req,resp);
            }

            req.getSession().setAttribute("principalUser", username);
            req.getSession().setAttribute("genders", Arrays.asList(Gender.values()));
            req.getRequestDispatcher("/jsp/form/save/profile-save.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Valid
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ProfileSaveServlet - post");

        try {
            String name = req.getParameter("name");
            String family = req.getParameter("family");
            String nationalCode = req.getParameter("nationalCode");
            String gender = req.getParameter("gender");

            String username = req.getUserPrincipal().getName();


            if (username != null) {
                Optional<User> user = userService.findByUsername(username);
                if (user.isPresent()) {
                    person = Person
                            .builder()
                            .name(name)
                            .family(family)
                            .nationalCode(nationalCode)
                            .gender(Gender.valueOf(gender))
                            .user(user.get())
//                            .deleted(false)
                            .build();
                    person.setDeleted(false);

                    //validate
                    BeanValidator<Person> validator = new BeanValidator<>();

                    if (validator.validate(person) != null){
                        resp.setStatus(500);
                        resp.getWriter().write(validator.validate(person).toString());
                    }

                    personService.save(person);
                    log.info("Person Saved");
                    resp.sendRedirect("/profile.do");
                }else {
                    resp.sendRedirect("");
                }
            }
        } catch (Exception e) {
            log.error("Person - POST : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
