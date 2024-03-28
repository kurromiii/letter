package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Attach;
import com.mftplus.letter.model.entity.Letter;
import com.mftplus.letter.model.service.impl.AttachServiceImpl;
import com.mftplus.letter.model.service.impl.LetterServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/attach.do")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 10 MB
)
public class AttachServlet extends HttpServlet {
    @Inject
    private AttachServiceImpl attachService;
    @Inject
    private LetterServiceImpl letterService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("AttachServlet - Get");
        try {
            req.getRequestDispatcher("/jsp/attach.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("AttachServlet - Post");
        try {
            //for uploading letter image
            String fileName = null;
            Part filePart = req.getPart("file");
            if (filePart.getSize()>0) {
                fileName = filePart.getSubmittedFileName();
                for (Part part : req.getParts()) {
                    part.write(fileName); //todo set server path
                }
                resp.getWriter().print("The file uploaded successfully.");
            }

            String letterId = req.getSession().getAttribute("letterId").toString();

            if (letterId != null){
                Optional<Letter> letter = letterService.findById(Long.valueOf(letterId));
                if (letter.isPresent()) {
                    Attach attach =
                            Attach
                                    .builder()
                                    .title(fileName)
//                                    .letter(letter.get())
                                    .build();
                    attachService.save(attach);
                    log.info("AttachServlet - Attach Saved");
                    resp.sendRedirect("/attach.do");
                }
            }


        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
