package com.startjava.lesson_2_3_4.exception;

public class InvalidMenuOptionException extends RuntimeException {
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}
