package com.mftplus.letter.controller.exception;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}
