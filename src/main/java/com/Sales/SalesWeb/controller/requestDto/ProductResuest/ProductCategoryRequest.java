package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.model.Category;
import com.Sales.SalesWeb.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;
@Getter
@Setter
public class ProductCategoryRequest extends ProductRequest {

    int page;
    Integer[] collectionIds;
    Integer categoryId;

    @Override
    public List<Map<Object, String>> toOrsPredicateMap() {
        return new ArrayList<>();
    }

    public Map<Object, String> toAndsPredicateMap() {
        return new HashMap<>();
    }

    private void getSubCategory(Map<Object, String> arg, Category category) {
        arg.put(category.getCategoryId(), "category.categoryId");
        List<Category> childCategorys = category.getChildCategory();
        if (childCategorys.size() > 0) {
            childCategorys.forEach(categoryItem -> getSubCategory(arg, categoryItem));
        }
    }

    public List<Map<Object, String>> toOrsPredicateMap(CategoryRepository categoryRepository) {
        List<Map<Object, String>> arg = new ArrayList<>();
        if (collectionIds != null && collectionIds.length != 0) {
            Map<Object, String> collectionMap = new HashMap<>();
            Arrays.stream(collectionIds).forEach(id -> collectionMap.put(id, "collection.collectionId"));
            arg.add(collectionMap);
        }
        if (categoryId != null && categoryId != 0) {
            Map<Object, String> categoryMap = new HashMap<>();
            categoryMap.put(categoryId, "category.categoryId");
            Category category = categoryRepository.findByCategoryId(categoryId);
            List<Category> childCategorys = category.getChildCategory();
            childCategorys.forEach(categoryItem -> getSubCategory(categoryMap, categoryItem));
            arg.add(categoryMap);
        }
        return arg;
    }
}