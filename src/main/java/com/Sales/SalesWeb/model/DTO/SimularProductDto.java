package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Image;
import com.Sales.SalesWeb.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
//@ToString
public class SimularProductDto {

    private UUID productId;

    private String nameProduct;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigDecimal price;

    private Image image;

    public SimularProductDto(UUID productId, String nameProduct, BigDecimal price, Image image) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
    }
}
