package com.Sales.SalesWeb.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@ToString
public class OrderDeliveryDto {
    private String adressDelivery;

    public OrderDeliveryDto(String adressDelivery) {
        this.adressDelivery = adressDelivery;
    }
}
