package com.Sales.SalesWeb.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FavoriteCategoryProductDto {

    private UUID favoriteCategoryProductId;

    private ProductDto Product;

    private FavoriteCategoryDto favoriteCategory;

    public FavoriteCategoryProductDto(UUID favoriteCategoryProductId, ProductDto product, FavoriteCategoryDto favoriteCategory) {
        this.favoriteCategoryProductId = favoriteCategoryProductId;
        Product = product;
        this.favoriteCategory = favoriteCategory;
    }
}
