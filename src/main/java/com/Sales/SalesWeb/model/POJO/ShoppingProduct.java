package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.Product;
import lombok.Data;

@Data
public class ShoppingProduct {
    String productName;
    Product product;
    Integer numberPieces;
    double priceNumberPieces;

    public ShoppingProduct(Product product, Integer numberPieces) {
        this.product = product;
        this.productName = product.getNameProduct();
        this.numberPieces = numberPieces;
        this.priceNumberPieces = product.getPrice().doubleValue() * numberPieces;
    }

    public void setNumberPieces(Integer numberPieces) {
        this.numberPieces = numberPieces;
        this.priceNumberPieces = product.getPrice().doubleValue() * this.numberPieces;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productName = product.getNameProduct();
        this.priceNumberPieces = this.product.getPrice().doubleValue() * this.numberPieces;
    }
}