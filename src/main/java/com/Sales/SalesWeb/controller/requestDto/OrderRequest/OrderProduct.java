package com.Sales.SalesWeb.controller.requestDto.OrderRequest;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderProduct {

    private UUID productId;

    private int productCount;

}