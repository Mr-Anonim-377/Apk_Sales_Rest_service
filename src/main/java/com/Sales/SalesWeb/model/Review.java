package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    private UUID reviewId;

    private String reviewTitle;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer review_mark;

    private String reviewDescription;


    @Enumerated(EnumType.STRING)
    @Column(name = "review_type")
    private ReviewType reviewType;
}
