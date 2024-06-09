package com.mftplus.letter.controller.servlet.letter;

import com.mftplus.letter.controller.exception.IdIsRequiredException;
import com.mftplus.letter.controller.exception.NoContentException;
import com.mftplus.letter.controller.validation.BeanValidator;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@WebServlet(urlPatterns = "/letterEdit.do")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 10 MB
)
public class LetterEditServlet extends HttpServlet {
    @Inject
    private LetterServiceImpl letterService;
    @Inject
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterEditServlet - Get");
        try {
            if (req.getParameter("id") == null) {
                throw new IdIsRequiredException("Please set letter id !");
            } else {
                long id = Integer.parseInt(req.getParameter("id"));
                Optional<Letter> letter = letterService.findById(id);
                letter.ifPresent(value -> req.getSession().setAttribute("letter", value));

                req.getSession().setAttribute("accessLevels", Arrays.asList(LetterAccessLevel.values()));
                req.getSession().setAttribute("transferMethods", Arrays.asList(TransferMethod.values()));
                req.getSession().setAttribute("letterTypes", Arrays.asList(LetterType.values()));
                req.getRequestDispatcher("/jsp/form/edit/letter-edit.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LetterEditServlet - put");
        try {
            long id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String letterNumber = req.getParameter("letter_number");
            String faDate = req.getParameter("date").replace("/", "-");
            String context = req.getParameter("context");
            String receiverName = req.getParameter("receiver_name");
            String receiverTitle = req.getParameter("receiver_title");
            String senderName = req.getParameter("sender_name");
            String senderTitle = req.getParameter("sender_title");
            String accessLevel = req.getParameter("accessLevel");
            String transferMethod = req.getParameter("transferMethod");
            String letterType = req.getParameter("letterType");

            String username = req.getUserPrincipal().getName();

            List<String> usernameList = new ArrayList<>();
            if(req.getParameterValues("users")!=null){
                usernameList = List.of(req.getParameterValues("users"));
            }

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

                Optional<User> user = userService.findByUsername(username);
                List<User> userList = userService.findUserByUsernames(usernameList);
                if (user.isPresent()) {
                    Letter letter =
                            Letter
                                    .builder()
                                    .id(id)
                                    .user(user.get())
                                    .title(title)
                                    .letterNumber(letterNumber)
                                    .context(context)
                                    .receiverName(receiverName)
                                    .receiverTitle(receiverTitle)
                                    .senderName(senderName)
                                    .senderTitle(senderTitle)
                                    .image(fileName)
                                    .deleted(false)
                                    .faDate(faDate)
                                    .accessLevel(LetterAccessLevel.valueOf(accessLevel))
                                    .transferMethod(TransferMethod.valueOf(transferMethod))
                                    .letterType(LetterType.valueOf(letterType))
                                    .userList(userList)
                                    .build();
                    letter.setFaDate(faDate);

                    //validate
                    BeanValidator<Letter> validator = new BeanValidator<>();

                    if (validator.validate(letter) != null){
                        resp.setStatus(500);
                        resp.getWriter().write(validator.validate(letter).toString());
                    }

                    letterService.edit(letter);
                    log.info("LetterEditServlet - Letter Edited");
                    resp.setStatus(200);
                    String msg = "تغییرات با موفقیت ثبت شد !";
                    req.getSession().setAttribute("ok",msg);
            } else {
                throw new NoContentException("The required user does not exist !");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
