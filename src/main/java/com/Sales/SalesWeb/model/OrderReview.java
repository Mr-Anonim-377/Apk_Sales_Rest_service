package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "order_reviews")
@Getter
@Setter
public class OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID orderReviewId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id")
    private Review review;

//    private UUID orderId;
//    private UUID ReviewId;
}


