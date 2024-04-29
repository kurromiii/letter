package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.service.impl.LetterServiceImpl;
import com.mftplus.letter.model.service.impl.ReferenceServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/letterBox.do")
public class LetterBoxServlet extends HttpServlet {
    @Inject
    private LetterServiceImpl letterService;

    @Inject
    private ReferenceServiceImpl referenceService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterBoxServlet - Get");

        try {
            req.getSession().setAttribute("letterList", letterService.findAll());
            req.getSession().setAttribute("referenceList", referenceService.findAll());
            req.getRequestDispatcher("/jsp/table/letter-box.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
