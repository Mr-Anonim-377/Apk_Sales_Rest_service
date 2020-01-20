package com.Sales.SalesWeb.model.POJO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ShoppingCart {
    Map<String, ShoppingProduct> products;
    private double totalAmount;
    Integer countProducts;
    Integer countProductsPieces;

    public ShoppingCart() {
        this.products = new HashMap<String, ShoppingProduct>();
    }

    public void setProducts(Map<String, ShoppingProduct> products) {
        this.products = products;
        this.totalAmount = products.values().stream().map(ShoppingProduct::getPriceNumberPieces).mapToDouble(a -> a).sum();
        this.countProducts = products.size();
        this.countProductsPieces = products.values().stream().map(ShoppingProduct::getNumberPieces).mapToInt(a -> a).sum();
    }

    public void validation(){
        this.totalAmount = products.values().stream().map(ShoppingProduct::getPriceNumberPieces).mapToDouble(a -> a).sum();
        this.countProducts = products.size();
        this.countProductsPieces = products.values().stream().map(ShoppingProduct::getNumberPieces).mapToInt(a -> a).sum();
    }

}


