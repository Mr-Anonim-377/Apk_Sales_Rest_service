package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "order_reviews")
@Data
public class Order_Reviews {

    @Id
    private UUID orderReviewId;

    private UUID orderId;

    private UUID reviewId;

}
