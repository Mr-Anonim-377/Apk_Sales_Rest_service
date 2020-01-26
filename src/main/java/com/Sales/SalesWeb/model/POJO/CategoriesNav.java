package com.Sales.SalesWeb.model.POJO;

import com.Sales.SalesWeb.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

