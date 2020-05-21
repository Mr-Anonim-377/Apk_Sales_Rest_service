package com.Sales.SalesWeb.controller.requestDto.UserRequest;

import lombok.Getter;

@Getter
public class PasswordChangeRequest {

    private String passwordOld;

    private String passwordNew;

    private String cod;
}
