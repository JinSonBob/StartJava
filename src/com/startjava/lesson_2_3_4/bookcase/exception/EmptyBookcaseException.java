package com.startjava.lesson_2_3_4.bookcase.exception;

public class EmptyBookcaseException extends RuntimeException {
    public EmptyBookcaseException(String message) {
        super(message);
    }
}
