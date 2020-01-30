package com.Sales.SalesWeb.model.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class ShoppingCart {
    private Map<String, ShoppingProduct> products;
    private BigDecimal totalAmount;
    private Integer countProducts;
    private Integer countProductsPieces;


    public ShoppingCart() {
        this.products = new HashMap<String, ShoppingProduct>();
    }


}


