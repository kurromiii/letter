package com.mftplus.letter.controller.servlet.letter;

import com.mftplus.letter.model.service.impl.LetterServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/letterTable.do")
public class LetterTable extends HttpServlet {
    @Inject
    private LetterServiceImpl letterService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterTableServlet - Get");
        try {
            req.getSession().setAttribute("letterList", letterService.findAll());
            req.getRequestDispatcher("/jsp/table/letter.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
