package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {

    private UUID productId;

    private String nameProduct;

    private CategoryDto productCategoryId;

    private BigDecimal price;

    private Image image;

    private Integer collectionId;

    private String properties;

    private String productDescription;

    public ProductDto(UUID productId, String nameProduct, CategoryDto productCategoryId, BigDecimal price, Image image,
                      Integer collectionId, String properties, String productDescription) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.productCategoryId = productCategoryId;
        this.price = price;
        this.image = image;
        this.collectionId = collectionId;
        this.properties = properties;
        this.productDescription = productDescription;
    }
}
