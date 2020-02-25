package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_reviews")
@Data
public class ProductReview {

    @Id
    private UUID productReviewsId;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="review_id")
    private Reviews review;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="product_id")
    private Product product;

}
