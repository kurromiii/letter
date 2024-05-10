package com.mftplus.letter.model.service.interfaces;

import com.mftplus.letter.controller.exception.NoContentException;
import com.mftplus.letter.model.entity.Letter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LetterService {
    void save(Letter letter) throws Exception;
    void edit(Letter letter) throws NoContentException;
    void remove(Letter letter) throws Exception;
    void removeById(Long id) throws Exception;

    Optional<Letter> findById(Long id) throws NoContentException;
    List<Letter> findAll() throws Exception;

    List<Letter> findByTitle(String title) throws Exception;
    List<Letter> findByContext(String context) throws Exception;
    List<Letter> findByDate(LocalDate date) throws Exception;
    Optional<Letter> findByRegisterNumber(Long registerNumber) throws Exception;
    List<Letter> findByRegisterDate(LocalDateTime dateTime) throws Exception;
    List<Letter> findBySenderNameAndTitle(String senderName,String senderTitle) throws Exception;

    List<Letter> findByUser(String user) throws  Exception;
    List<Letter> findByUserAndDeletedFalse(String user) throws Exception;



}
