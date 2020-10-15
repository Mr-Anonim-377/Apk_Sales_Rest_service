package com.Sales.SalesWeb.model.response.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShoppingCart {
    private List<ShoppingProduct> products;
    private BigDecimal totalAmount;
    private Integer countProducts;
    private Integer countProductsPieces;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void clear() {
        products = new ArrayList<>();
        totalAmount = null;
        countProducts = null;
        countProductsPieces = null;
    }

}