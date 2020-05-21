package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.requestDto.UserRequest.UserRegistrationRequest;
import com.Sales.SalesWeb.controller.requestDto.changeRequestType.RegisterCodRequest;
import com.Sales.SalesWeb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@SessionAttributes(types = RegisterCodRequest.class)
@RequestMapping(value = "request/type", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterRequestController {

    private final UserService userService;

    public RegisterRequestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRegistrationRequest(@RequestParam String  email,
                                              RegisterCodRequest cod) {
        userService.createRegisterRequest(email,cod);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity validationRegistrationRequest(@RequestBody RegisterCodRequest userCode,
                                              RegisterCodRequest cod) {
        if (userService.vlidationRegisterRequest(userCode, cod)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
