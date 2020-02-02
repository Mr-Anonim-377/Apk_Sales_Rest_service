package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class FavoriteCategoryProductsResponse {
    private String favoriteCategory;
    private Integer popularValue;
    private List<Product> products;

    public FavoriteCategoryProductsResponse() {
    }

    public FavoriteCategoryProductsResponse(String favoriteCategory, Integer popularValue, List<Product> products) {
        this.favoriteCategory = favoriteCategory;
        this.popularValue = popularValue;
        this.products = products;
    }
}
