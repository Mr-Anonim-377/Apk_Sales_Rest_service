package com.Sales.SalesWeb.controller.requestDto.OrderRequest;

import lombok.Data;

@Data
public class OrderResponse {

    public OrderResponse(String cod) {
        this.cod = cod;
    }

    private String cod;
}