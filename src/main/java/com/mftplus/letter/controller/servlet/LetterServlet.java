package com.mftplus.letter.controller.servlet;

import com.mftplus.letter.model.entity.Letter;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.entity.enums.LetterAccessLevel;
import com.mftplus.letter.model.entity.enums.LetterType;
import com.mftplus.letter.model.entity.enums.TransferMethod;
import com.mftplus.letter.model.service.impl.LetterServiceImpl;
import com.mftplus.letter.model.service.impl.UserServiceImpl;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@WebServlet (urlPatterns = "/letter.do")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 10 MB
)
public class LetterServlet extends HttpServlet {
    @Inject
    private LetterServiceImpl letterService;

    @Inject
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterServlet - GET");

//        for select box
//        req.getParameter("accessLevel");
//        req.getSession().setAttribute("accessLevel", Arrays.asList(LetterAccessLevel.values()));
//        req.getRequestDispatcher("/jsp/letter.jsp").forward(req,resp);
//        try {
//            System.out.println(letterService.findAll());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try {
            log.info("first");
           req.getSession().setAttribute("letterList", letterService.findAll());
            log.info("last");
            req.getRequestDispatcher("/jsp/letter.jsp").forward(req, resp);
            log.info("after last");
            System.out.println(letterService.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterServlet - Post");
        try {
            //inputs
            String title = req.getParameter("l_title");
            String letterNumber = req.getParameter("l_letter_number");
//            String faDate = req.getParameter("l_date");
            String context = req.getParameter("l_context");
            String receiverName = req.getParameter("l_receiver_name");
            String receiverTitle = req.getParameter("l_receiver_title");
            String senderName = req.getParameter("l_sender_name");
            String senderTitle = req.getParameter("l_sender_title");

            //enum
//            String accessLevel = req.getSession().getAttribute("accessLevel").toString();
//            String transferMethod = req.getParameter("transferMethod");
//            String letterType = req.getParameter("letterType");

            //getting username from session
//            String username = req.getSession().getAttribute("username").toString();
//
//            String registerNumber = req.getParameter("registerNumber");
//            String indicatorCode = req.getParameter("indicatorCode");
//            String refReceivers = req.getParameter("refReceiver");
//            String carbonCopies = req.getParameter("carbonCopies");

            //for uploading letter image
//            Part filePart = req.getPart("file");
//            String fileName = filePart.getSubmittedFileName();
//            for (Part part : req.getParts()) {
//                part.write("E:\\JavaFinalProject\\letter\\src\\main\\resources\\img"+fileName); //todo set server path
//            }
//            resp.getWriter().print("The file uploaded successfully.");

            //verify
//            if (context != null){
                //using username session to find user
//                Optional<User> user = userService.findByUsername(username);
//                if (user.isPresent()) {

                    //for register time
//                    LocalDateTime localDateTime = LocalDateTime.now();
            Letter letter =
                            Letter
                                    .builder()
                                    .title(title)
                                    .letterNumber(letterNumber)
                                    .context(context)
                                    .receiverName(receiverName)
                                    .receiverTitle(receiverTitle)
                                    .senderName(senderName)
                                    .senderTitle(senderTitle)
                                    .deleted(false)
                                    .build();
                    letterService.save(letter);
                    log.info("LetterServlet - Letter Saved");
//                    req.getSession().setAttribute("letter",letter);
//                }
//            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

//todo indicator code
//todo letter number format
//todo carbonCopies
//todo refReceivers
//todo register number
//todo exception handling
//todo test needed
