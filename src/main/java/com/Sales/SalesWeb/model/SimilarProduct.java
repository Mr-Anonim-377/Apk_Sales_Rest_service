package com.Sales.SalesWeb.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "similar_product")
@Getter
@Setter
public class SimilarProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID similarProductId;

    @OneToOne()
    @JoinColumn(name = "similars_product_id")
    private Product similarsProduct;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
