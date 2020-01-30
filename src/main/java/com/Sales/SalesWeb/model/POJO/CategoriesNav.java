package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoriesNav {
    private String name;
    private Category category;
    private List<CategoriesNav> childCategories;

    public CategoriesNav(String name, Category category, List<CategoriesNav> childCategories) {
        this.name = name;
        this.category = category;
        this.childCategories = childCategories;
    }

}


