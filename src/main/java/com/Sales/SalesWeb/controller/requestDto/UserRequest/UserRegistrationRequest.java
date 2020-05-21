package com.Sales.SalesWeb.controller.requestDto.UserRequest;

import lombok.Getter;

@Getter
public class UserRegistrationRequest {

    private String cod;

    private String email;

    private String password;

    private String imagePath;

    private String phone;

    private String lastName;

    private String firstName;
}
