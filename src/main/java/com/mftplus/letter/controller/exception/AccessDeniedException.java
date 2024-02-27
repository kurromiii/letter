package com.mftplus.letter.controller.exception;

public class AccessDeniedException extends Throwable {
    public AccessDeniedException(String message) {
        super(message);
    }
}
