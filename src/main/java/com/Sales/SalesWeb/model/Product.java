package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity()
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;


    private String nameProduct;

    private Integer productCategoryId;

    private BigDecimal price;

    private UUID imageId;

    private Integer collectionId;

//    @Column(name = "properties")
//    @Type(type = "com.Sale.SalesWeb.model.dataType.JsonType")
//    private JsonElement properties;
    private String properties;

    private String productDescription;
}
