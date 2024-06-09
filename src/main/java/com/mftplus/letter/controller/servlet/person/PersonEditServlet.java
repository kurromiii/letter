package com.mftplus.letter.controller.servlet.person;

import com.mftplus.letter.controller.exception.IdIsRequiredException;
import com.mftplus.letter.controller.exception.NoContentException;
import com.mftplus.letter.controller.validation.BeanValidator;
import com.mftplus.letter.model.entity.Person;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.Gender;
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
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/personEdit.do")
public class PersonEditServlet extends HttpServlet {
    @Inject
    private PersonServiceImpl personService;

    @Inject
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PersonEditServlet - Get");
        try {
            if (req.getParameter("id") == null) {
                throw new IdIsRequiredException("Please set person id !");
            } else {
                long id = Long.parseLong(req.getParameter("id"));
                Optional<Person> person = personService.findById(id);
                person.ifPresent(value -> req.getSession().setAttribute("person", value));

                req.getSession().setAttribute("gender", Arrays.asList(Gender.values()));
                req.getRequestDispatcher("/jsp/form/edit/profile-edit.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PersonEditServlet - Post");
        try {
            long id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String family = req.getParameter("family");
            String nationalCode = req.getParameter("nationalCode");
            String gender = req.getParameter("gender");

            String username = req.getUserPrincipal().getName();

            Optional<User> user = userService.findByUsername(username);

            if (user.isPresent()){
                Person person = Person
                        .builder()
                        .id(id)
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

                //todo : problem with redirect after edit, does not redirect
                personService.edit(person);
                log.info("PersonEditServlet - Person Edited");
                resp.setStatus(200);
            } else {
                throw new NoContentException("The required user does not exist !");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
