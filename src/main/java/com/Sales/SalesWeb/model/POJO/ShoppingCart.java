package com.Sales.SalesWeb.model.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class ShoppingCart {
    Map<String, ShoppingProduct> products;
    BigDecimal totalAmount;
    Integer countProducts;
    Integer countProductsPieces;


    public ShoppingCart() {
        this.products = new HashMap<String, ShoppingProduct>();
    }


}


