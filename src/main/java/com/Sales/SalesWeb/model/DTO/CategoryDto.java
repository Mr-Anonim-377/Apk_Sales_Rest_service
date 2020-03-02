package com.Sales.SalesWeb.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryDto {
    public CategoryDto(Integer categoryId, Integer parentCategoryId, List<CategoryDto> childCategory,
                       List<UUID> categoryProducts, String categoryName) {
        this.categoryId = categoryId;
        this.parentCategoryId = parentCategoryId;
        this.childCategory = childCategory;
        this.categoryName = categoryName;
        this.categoryProducts = categoryProducts;
    }

    private Integer categoryId;

    private Integer parentCategoryId;

    private List<CategoryDto> childCategory;

    private List<UUID> categoryProducts;

    private String categoryName;
}
