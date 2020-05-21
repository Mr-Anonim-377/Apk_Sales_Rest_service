package com.Sales.SalesWeb.model.POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public void clear(){
        products = new ArrayList<>();
        totalAmount = null;
        countProducts = null;
        countProductsPieces = null;
    }

}


