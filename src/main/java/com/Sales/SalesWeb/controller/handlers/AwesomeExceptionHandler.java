package com.Sales.SalesWeb.controller.handlers;

import com.Sales.SalesWeb.controller.exception.*;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
@Slf4j
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LL-yyyy/HH:mm:ss");

    @ExceptionHandler(NoSuchObject.class)
    protected ResponseEntity<ApiExceptionResponse> handleNoSuchObject() {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "No such object in db","Objet==null",
                ExceptionType.NoSuchObj), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ApiExceptionResponse> handleApiExeption(ApiException exc) {
        return new ResponseEntity<>(new ApiExceptionResponse(
                exc.getDataTime(),
                exc.getMessage(),
                exc.getReason(),
                exc.getType()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchObjects.class)
    protected ResponseEntity<ApiExceptionResponse> handleNoSuchObjects() {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "No such objects in db","Objets==null",
                ExceptionType.NoSuchObjs), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiExceptionResponse> handleNoHttpValidationParametrs() {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "No Valid request param","reqestParam!=expected",
                ExceptionType.ArgumentTypeMismatch), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalDataBaseServerExeption.class)
    protected ResponseEntity<ApiExceptionResponse> handleIntermalServerError(Exception exc) {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "Service error, try again later","the database query",
                ExceptionType.InternalServerError), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadParamForRequest.class)
    protected ResponseEntity<ApiExceptionResponse> handleBadParamForReqest(Exception exc) {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "Bad param for request","",
                ExceptionType.BadParamForRequest), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShoppingProductNotSuch.class)
    protected ResponseEntity<ApiExceptionResponse> handleShoppingProductNotSuch(Exception exc) {
        return new ResponseEntity<>(new ApiExceptionResponse(
                LocalDateTime.now().format(formatter),
                "Shopping product not such","shopProduct==null",
                ExceptionType.NoSuchObj), HttpStatus.BAD_REQUEST);
    }

    @Data
    private static class ApiExceptionResponse{
        private String dateTime;
        private String message;
        private ExceptionType type;
        private String reason;

        public ApiExceptionResponse(String dateTime, String message, String reason, ExceptionType type) {
            log.error(String.format("Message: %s; Because: %s; Type: %s", message, reason, type));
            this.dateTime = dateTime;
            this.message = message;
            this.type = type;
            this.reason = reason;
        }
    }
}
