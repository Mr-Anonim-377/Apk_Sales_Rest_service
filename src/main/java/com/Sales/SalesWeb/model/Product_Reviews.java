package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_reviews")
@Data
public class Product_Reviews {

    @Id
    private UUID productReviewsId;

    private UUID reviewId;

    private UUID productId;

}
