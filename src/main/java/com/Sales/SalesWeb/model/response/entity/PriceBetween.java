package com.Sales.SalesWeb.model.response.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PriceBetween {

    private BigDecimal totalMinPrice;
    private BigDecimal totalMaxPrice;

    public PriceBetween(BigDecimal totalMinPrice, BigDecimal totalMaxPrice) {
        this.totalMinPrice = totalMinPrice;
        this.totalMaxPrice = totalMaxPrice;
    }
}
