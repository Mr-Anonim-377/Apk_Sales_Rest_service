package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
//@ToString
public class ProductReviewDto {

    private UUID productReviewsId;

    private ReviewDto review;

    private UUID productId;

    public ProductReviewDto(UUID productReviewsId, ReviewDto review, UUID productId) {
        this.productReviewsId = productReviewsId;
        this.review = review;
        this.productId = productId;
    }
}
