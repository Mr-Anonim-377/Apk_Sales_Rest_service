package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ShoppingProduct {
    String productName;
    Product product;
    Integer numberPieces;
    BigDecimal priceNumberPieces;

    public ShoppingProduct(Product product, Integer numberPieces) {
        this.product = product;
        this.productName = product.getNameProduct();
        this.numberPieces = numberPieces;
        this.priceNumberPieces = BigDecimal.valueOf(product.getPrice().doubleValue() * numberPieces);
    }

    public void setNumberPieces(Integer numberPieces) {
        this.numberPieces = numberPieces;
        this.priceNumberPieces = BigDecimal.valueOf(product.getPrice().doubleValue() * this.numberPieces);
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productName = product.getNameProduct();
        this.priceNumberPieces = BigDecimal.valueOf(this.product.getPrice().doubleValue() * this.numberPieces);
    }
}