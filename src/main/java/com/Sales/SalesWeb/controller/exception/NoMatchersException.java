package com.Sales.SalesWeb.controller.exception;

public class NoMatchersException extends RuntimeException {

    public NoMatchersException(String message) {
        super(message);
    }
}
