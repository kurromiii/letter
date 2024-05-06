package com.mftplus.letter.controller.servlet.person;

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
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/person.do")
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
//        maxFileSize = 1024 * 1024 * 10,      // 10 MB
//        maxRequestSize = 1024 * 1024 * 100   // 100 MB
//)
public class PersonServlet extends HttpServlet {
    @Inject
    private PersonServiceImpl personService;

    @Inject
    private UserServiceImpl userService;

    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PersonServlet - Get");
        try {
            req.getSession().setAttribute("genders", Arrays.asList(Gender.values()));
            req.getSession().setAttribute("personList", personService.findAll());
            req.getRequestDispatcher("/jsp/form/person-form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Person - GET : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Valid
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("PersonServlet - post");
//        Part filePart = req.getPart("file");
//        String fileName = filePart.getSubmittedFileName();  // todo : attach_id
//        for (Part part : req.getParts()) {
//            part.write("c:\\root\\"+fileName);  // todo : set server path
//        }

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
                    personService.save(person);
                    log.info("Person Saved");
                    resp.sendRedirect("/person.do");
                }else {
                    resp.sendRedirect("");
                }
            }
        } catch (Exception e) {
            log.error("Person - POST : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personId = req.getParameter("id");
        int id = Integer.parseInt(personId);

        try{ personService.removeById((long) id);

        }catch (Exception e){
            System.out.println(e.getMessage());
            log.info("PersonServlet - Error Delete Person By Id");
            req.getSession().setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/person.jsp").forward(req, resp);
        }
    }
}
