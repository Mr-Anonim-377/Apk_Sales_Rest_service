package com.Sales.SalesWeb.model.response.entity;

import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import lombok.Data;

import java.util.List;

@Data
public class ResponseNavigationEntity {
    private List<FavoriteCategoryDto> favoriteCategories;
    private List<CategoryDto> categoriesNavigation;
}


