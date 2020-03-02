package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity()
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    private String nameProduct;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName ="categoryId", name = "product_category_id")
    private Category category;

    private BigDecimal price;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "collectionId", name = "collection_id")
    private Collection collection;

    //    @Column(name = "properties")
//    @Type(type = "com.Sale.SalesWeb.model.dataType.JsonType")
//    private JsonElement properties;
    private String properties;

    private String productDescription;
}
