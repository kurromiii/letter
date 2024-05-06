package com.mftplus.letter.controller.servlet.reference;

import com.mftplus.letter.controller.exception.NoReferenceFoundException;
import com.mftplus.letter.controller.exception.ReferenceIdIsRequiredException;
import com.mftplus.letter.model.entity.Reference;
import com.mftplus.letter.model.entity.enums.ReferencePriority;
import com.mftplus.letter.model.entity.enums.ReferenceType;
import com.mftplus.letter.model.service.impl.ReferenceServiceImpl;
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
@WebServlet(urlPatterns = "/referenceDisplay.do")
public class ReferenceDisplayServlet extends HttpServlet {
    @Inject
    private ReferenceServiceImpl referenceService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("ReferenceDisplayServlet - Get");
        try {
            if (req.getParameter("id") == null) {
                throw new ReferenceIdIsRequiredException("Please set reference id !");
            } else {
                long id = Integer.parseInt(req.getParameter("id"));
                Optional<Reference> reference = referenceService.findById(id);
                if (reference.isPresent()) {
                    req.getSession().setAttribute("reference", reference.get());
                }else {
                    log.error("reference not present");
                    throw new NoReferenceFoundException("reference with id : "+ id + " not found !");
                }
                req.getSession().setAttribute("refTypes", Arrays.asList(ReferenceType.values()));
                req.getSession().setAttribute("priorities", Arrays.asList(ReferencePriority.values()));
                req.getSession().setAttribute("referenceList", referenceService.findAll());
                req.getRequestDispatcher("/jsp/form/display/reference.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
