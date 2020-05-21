package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productId;

    private String nameProduct;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews  = new ArrayList<>();

    private BigDecimal price;

    @OneToOne()
    @JoinColumn(name = "image_id")
    private Image mainImage;

    @OneToMany(mappedBy = "product")
    private List<ImagesProduct> images = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<SimilarProduct> similarProducts = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "collection_id")
    private Collection collection;

    //    @Column(name = "properties")
//    @Type(type = "com.Sale.SalesWeb.model.dataType.JsonType")
//    private JsonElement properties;
    private String properties;

    private String productDescription;

    private BigDecimal averageMark;

    private Integer sumMark ;

}
