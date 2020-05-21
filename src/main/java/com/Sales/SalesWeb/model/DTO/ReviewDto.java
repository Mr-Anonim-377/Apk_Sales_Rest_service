package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReviewDto {

    private UUID reviewId;

    private String reviewTitle;

    private UserDto user;

    public ReviewDto(UUID reviewId,
                     String reviewTitle,
                     UserDto user,
                     Integer reviewMark,
                     String reviewDescription,
                     ReviewType reviewType) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.user = user;
        this.reviewMark = reviewMark;
        this.reviewDescription = reviewDescription;
        this.reviewType = reviewType;
    }

    private Integer reviewMark;

    private String reviewDescription;

    private ReviewType reviewType;

}
