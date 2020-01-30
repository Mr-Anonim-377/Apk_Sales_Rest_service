package com.Sales.SalesWeb.model.POJO;

import lombok.Data;

import java.util.List;

@Data
public class Navigation {
    private List<FavoriteCategoryNav> favoriteCategories;
    private List<CategoriesNav> categoriesNavigation;



}


