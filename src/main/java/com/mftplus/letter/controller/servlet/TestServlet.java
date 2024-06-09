package com.mftplus.letter.controller.servlet;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/test.do")
public class TestServlet extends HttpServlet {
    @Inject
    private UserServiceImpl userService;
    @Inject
    private LetterServiceImpl letterService;
    @Inject
    private ReferenceServiceImpl referenceService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Optional<User> user1 = userService.findByUsername("admin");
            Optional<User> user2 = userService.findByUsername("user");


            for (int i = 0; i < 20; i++) {
                Letter letter = Letter.builder()
                        .title("test")
                        .letterNumber("12345")
                        .user(user1.get())
                        .senderName("test")
                        .senderTitle("test")
                        .receiverName("test")
                        .receiverTitle("test")
                        .accessLevel(LetterAccessLevel.normal)
                        .transferMethod(TransferMethod.email)
                        .letterType(LetterType.sending)
                        .date(LocalDate.now())
                        .context("context text")
                        .registerDateAndTime(LocalDateTime.now())
                        .deleted(false)
                        .build();
                letterService.save(letter);

                Reference reference = Reference.builder()
                        .letterId(letter)
                        .refType(ReferenceType.eghdam)
                        .priority(ReferencePriority.normal)
                        .referenceSenderId(user1.get())
                        .referenceReceiverId(user1.get())
                        .refDateAndTime(LocalDateTime.now())
                        .paraph("test")
                        .explanation("test")
                        .expiration(LocalDateTime.of(2025,11,21,12,24,34))
                        .deleted(false)
                        .build();
                referenceService.save(reference);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
