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
public class ProductDto {

    private UUID productId;

    private String nameProduct;

    private CategoryDto productCategory;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    private Image image;

    private List<ImagesProductDto> images;

    private List<SimularProductDto> similarProducts;

    private CollectionDto collection;

    private String properties;

    private String productDescription;

    private BigDecimal averageMark;

    private List<ProductReviewDto> orderProducts;

    public ProductDto(UUID productId,
                      String nameProduct,
                      CategoryDto productCategory,
                      BigDecimal price,
                      Image image,
                      List<ImagesProductDto> images,
                      List<SimularProductDto> similarProducts,
                      CollectionDto collection,
                      String properties,
                      String productDescription,
                      BigDecimal averageMark,
                      List<ProductReviewDto> orderProducts) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.productCategory = productCategory;
        this.price = price;
        this.image = image;
        this.images = images;
        this.similarProducts = similarProducts;
        this.collection = collection;
        this.properties = properties;
        this.productDescription = productDescription;
        this.averageMark = averageMark;
        this.orderProducts = orderProducts;
    }
}
