package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Image;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
//@ToString
public class ImagesProductDto {

    private UUID imagesProduct;

    private Image image;

    public ImagesProductDto(UUID imagesProduct, Image image) {
        this.imagesProduct = imagesProduct;
        this.image = image;
    }
}
