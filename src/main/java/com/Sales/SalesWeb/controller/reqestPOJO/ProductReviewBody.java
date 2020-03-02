package com.Sales.SalesWeb.controller.reqestPOJO;

import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductReviewBody {

    private UUID productId;

    private String reviewTitle;

    private UUID userId;

    private Integer reviewMark;

    private String reviewDescription;

    private ReviewType reviewType;
}
