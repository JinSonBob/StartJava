package com.startjava.lesson_2_3_4.exception;

public class EmptyShelfException extends RuntimeException {
    public EmptyShelfException(String message) {
        super(message);
    }
}
