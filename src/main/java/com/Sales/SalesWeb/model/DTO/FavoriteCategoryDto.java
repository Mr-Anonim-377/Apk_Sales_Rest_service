package com.Sales.SalesWeb.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FavoriteCategoryDto {
    private UUID favoriteCategoryId;

    private CategoryDto category;

    private Integer popularValue;

    public FavoriteCategoryDto(UUID favoriteCategoryId, CategoryDto category, Integer popularValue) {
        this.favoriteCategoryId = favoriteCategoryId;
        this.category = category;
        this.popularValue = popularValue;
    }
}
