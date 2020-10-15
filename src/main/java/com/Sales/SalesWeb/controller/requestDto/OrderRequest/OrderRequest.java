package com.Sales.SalesWeb.controller.requestDto.OrderRequest;

import com.Sales.SalesWeb.model.User;
import com.Sales.SalesWeb.model.dbEnums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderRequest {

    private Boolean isPayment;

    private PaymentType paymentType;

    private String email;

    private String phone;

    private String firstName;

    private String lastName;

    private String adress;

    private UUID deliveryId;

    private List<OrderProduct> productIds;

}