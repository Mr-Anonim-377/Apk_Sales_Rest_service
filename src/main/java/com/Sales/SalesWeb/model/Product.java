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

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="collection_id")
    private Collection collection;

    //    @Column(name = "properties")
//    @Type(type = "com.Sale.SalesWeb.model.dataType.JsonType")
//    private JsonElement properties;
    private String properties;

    private String productDescription;
}
