package com.mftplus.letter.controller.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class MyException extends Exception {
    private int statusCode;
    private String statusText;

    public MyException(String message) {
        super(message);
        statusText = message;
    }
}
