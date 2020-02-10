package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@Data
public class Reviews {

    @Id
    private UUID reviewId;

    private String reviewTitle;

    private UUID userId;

    private Integer reviewMark;

    private String reviewDescription;
    @Enumerated(EnumType.STRING)
    @Column(name = "review_type")
    private ReviewType reviewType;
}
