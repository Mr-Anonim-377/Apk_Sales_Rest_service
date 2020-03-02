package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "favorite_category")
@Getter
@Setter
public class FavoriteCategory {

    @Id
    private UUID favoriteCategoryId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
//    private Integer categoryId;

    private Integer popularValue;

}
