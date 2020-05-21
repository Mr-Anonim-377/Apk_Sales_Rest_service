package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "favorite_category_products")
@Getter
@Setter
public class FavoriteCategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID favoriteCategoryProductId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product Product;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_category_id")
    private FavoriteCategory favoriteCategory;
}
