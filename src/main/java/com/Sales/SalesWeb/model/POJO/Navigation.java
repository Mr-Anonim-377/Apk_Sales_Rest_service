package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import lombok.Data;

import java.util.List;

@Data
public class Navigation {
    private List<FavoriteCategoryDto> favoriteCategories;
    private List<CategoryDto> categoriesNavigation;
}


