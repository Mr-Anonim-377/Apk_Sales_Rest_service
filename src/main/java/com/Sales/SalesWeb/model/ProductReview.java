package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_reviews")
@Getter
@Setter
public class ProductReview {

    @Id
    private UUID productReviewsId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
