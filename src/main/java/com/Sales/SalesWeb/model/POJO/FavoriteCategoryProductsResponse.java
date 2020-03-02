package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class FavoriteCategoryProductsResponse {
    private FavoriteCategoryDto favoriteCategory;
    private List<ProductDto> products;
    
    public FavoriteCategoryProductsResponse(FavoriteCategoryDto favoriteCategory, List<ProductDto> products) {
        this.favoriteCategory = favoriteCategory;
        this.products = products;
    }
}
