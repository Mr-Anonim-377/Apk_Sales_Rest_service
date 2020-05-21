package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dataType.PgEnumUserType;
import com.Sales.SalesWeb.model.dbEnums.ReviewType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    private UUID reviewId;

    private String reviewTitle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer reviewMark;

    private String reviewDescription;

    @Type(type = PgEnumUserType.TYPE,parameters = @org.hibernate.annotations.Parameter(
            name=PgEnumUserType.ENUM_CLASS_NAME,value = "com.Sales.SalesWeb.model.dbEnums.ReviewType"))
    @Column(name = "review_type")
    private ReviewType reviewType;
}
