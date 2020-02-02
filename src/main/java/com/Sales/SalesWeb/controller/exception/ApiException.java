package com.Sales.SalesWeb.controller.exception;

import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {
    private final DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-LL-yyyy/HH:mm:ss");
    private String dataTime = LocalDateTime.now().format(formatter);
    private ExceptionType type;
    private String reason;

    public ApiException(String message, String reason, ExceptionType type) {
        super(message);
        this.reason = reason;
        this.type = type;
    }

}
