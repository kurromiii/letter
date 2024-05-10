package com.mftplus.letter.controller.servlet.reference;

import com.mftplus.letter.controller.exception.NoUserFoundException;
import com.mftplus.letter.model.entity.Letter;
import com.mftplus.letter.model.entity.Reference;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.*;
import com.mftplus.letter.model.service.impl.LetterServiceImpl;
import com.mftplus.letter.model.service.impl.ReferenceServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@WebServlet (urlPatterns = "/reference.do")
public class ReferenceServlet extends HttpServlet {
    @Inject
    private ReferenceServiceImpl referenceService;

    @Inject
    private UserServiceImpl userService;

    @Inject
    private LetterServiceImpl letterService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ReferenceServlet - Get");
        try {
            req.getSession().setAttribute("refTypes", Arrays.asList(ReferenceType.values()));
            req.getSession().setAttribute("priorities", Arrays.asList(ReferencePriority.values()));
            req.getSession().setAttribute("referenceList", referenceService.findAll());
            req.getSession().setAttribute("letterIdRef",req.getParameter("letterIdRef"));
            req.getSession().setAttribute("user",req.getUserPrincipal().getName());
            req.getRequestDispatcher("/jsp/form/reference-form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ReferenceServlet - Post");
        try {
                String letterId = req.getParameter("letterIdRef");
                String refType = req.getParameter("refType");
                String priority = req.getParameter("priority");
                String faExpiration = req.getParameter("r_expiration");
                String paraph = req.getParameter("paraph");
                String explanation = req.getParameter("explanation");
                String status = req.getParameter("status");
                String referenceReceiver = req.getParameter("referenceReceiver");
                boolean validate = req.getParameter("validate") != null && req.getParameter("validate").equals("on");

                String username = req.getUserPrincipal().getName();

//            if (letterId != null){

                Optional<User> user = userService.findByUsername(username);
                if (user.isEmpty()){
                    throw new NoUserFoundException("no user found for reference !");
                }
                Optional<User> referenceReceiverId = userService.findByUsername(referenceReceiver);
                if (referenceReceiverId.isEmpty()){
                    throw new NoUserFoundException("no user found for reference receiver !");
                }

            //todo : number format exception
            Optional<Letter> letter = letterService.findById(Long.valueOf(letterId));

                if (letter.isPresent()){
                    Reference reference =
                            Reference
                                    .builder()
                                    .letterId(letter.get())
                                    .referenceSenderId(user.get())
                                    .refDateAndTime(LocalDateTime.now())
                                    .paraph(paraph)
                                    .explanation(explanation)
                                    .status(Boolean.parseBoolean(status))
                                    .validate(validate)
                                    .priority(ReferencePriority.valueOf(priority))
                                    .refType(ReferenceType.valueOf(refType))
                                    .faExpiration(faExpiration)
                                    .deleted(false)
                                    .referenceReceiverId(referenceReceiverId.get())
                                    .build();
                    reference.setFaExpiration(faExpiration);
                    referenceService.save(reference);
                    log.info("ReferenceServlet - Reference Saved");
                resp.sendRedirect("/reference.do");
                }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

