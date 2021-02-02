package com.project.carrental.exception;

/**
 * Custom exception class for handling the session timeouts
 *
 */
public class SessionTimeoutException extends Exception {

    public SessionTimeoutException(String message) {
        super(message);
    }

    public SessionTimeoutException(Throwable cause) {
        super(cause);
    }
}