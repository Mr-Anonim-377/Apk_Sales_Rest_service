package com.Sales.SalesWeb.controller.requestDto.ReviewRequest;

import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Getter;

import java.util.UUID;
@Getter
public class ReviewRequest {

    private String title;

    private String userEmail;

    private Integer mark;

    private String discription;

    private ReviewType reviewType;

    private UUID productId;

}
