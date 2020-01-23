package com.Sales.SalesWeb.model.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class ShoppingCart {
    Map<String, ShoppingProduct> products;
    private BigDecimal totalAmount;
    Integer countProducts;
    Integer countProductsPieces;

    public ShoppingCart() {
        this.products = new HashMap<String, ShoppingProduct>();
    }

//    public void setProducts(Map<String, ShoppingProduct> products) {
//        this.products = products;
//        this.totalAmount = BigDecimal.valueOf(products.values().stream().map(ShoppingProduct::getPriceNumberPieces).mapToDouble(a -> a).sum());
//        this.countProducts = products.size();
//        this.countProductsPieces = products.values().stream().map(ShoppingProduct::getNumberPieces).mapToInt(a -> a).sum();
//    }

}


