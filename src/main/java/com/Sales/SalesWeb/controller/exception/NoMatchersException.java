package com.Sales.SalesWeb.controller.exception;

import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;

public class NoMatchersException extends ApiException {

    public NoMatchersException(String message) {
        super(message, message, ExceptionType.MatchError);
    }
}