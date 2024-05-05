package com.mftplus.letter.controller.servlet.letter;

import com.mftplus.letter.controller.exception.LetterIdIsRequiredException;
import com.mftplus.letter.controller.exception.NoLetterFoundException;
import com.mftplus.letter.model.entity.Letter;
import com.mftplus.letter.model.entity.enums.LetterAccessLevel;
import com.mftplus.letter.model.entity.enums.LetterType;
import com.mftplus.letter.model.entity.enums.TransferMethod;
import com.mftplus.letter.model.service.impl.LetterServiceImpl;
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
@WebServlet(urlPatterns = "/letterDisplay.do")
public class LetterDisplayServlet extends HttpServlet {
    @Inject
    private LetterServiceImpl letterService;

    //todo : a better way instead of 500 error page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterDisplayServlet - Get");
        try {
            if (req.getParameter("id") == null) {
                throw new LetterIdIsRequiredException("Please set letter id !");
            } else {
                long id = Integer.parseInt(req.getParameter("id"));
                Optional<Letter> letter = letterService.findById(id);
                if (letter.isPresent()) {
                    req.getSession().setAttribute("letter", letter.get());
                }else {
                    log.error("letter not present");
                    throw new NoLetterFoundException("letter with id : "+ id + " not found !");
                }
                req.getSession().setAttribute("accessLevels", Arrays.asList(LetterAccessLevel.values()));
                req.getSession().setAttribute("transferMethods", Arrays.asList(TransferMethod.values()));
                req.getSession().setAttribute("letterTypes", Arrays.asList(LetterType.values()));
                req.getRequestDispatcher("/jsp/form/display/letter.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
