package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.FavoriteCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteCategoryNav {
    String favoriteCategoryName;
    FavoriteCategory favoriteCategory;
}
