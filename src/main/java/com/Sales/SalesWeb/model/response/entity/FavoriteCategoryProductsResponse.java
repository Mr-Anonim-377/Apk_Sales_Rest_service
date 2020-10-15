package com.Sales.SalesWeb.model.response.entity;

import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FavoriteCategoryProductsResponse {
    private FavoriteCategoryDto favoriteCategory;
    private List<ProductDto> products;
    
    public FavoriteCategoryProductsResponse(FavoriteCategoryDto favoriteCategory, List<ProductDto> products) {
        this.favoriteCategory = favoriteCategory;
        this.products = products;
    }
}
