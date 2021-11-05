package com.pashin.pharmacyweb.exception;

public class InvalidUserException extends Exception {

    public InvalidUserException() {
    }

    public InvalidUserException(String message) {
        super(message);
    }
}
