package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import com.Sales.SalesWeb.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
public class ProductCollectionRequest extends ProductRequest {
    int page;
    Integer collectionId;
    Integer[] categoryIds;

    public Map<Object, String> toAndsPredicateMap() {
        Map<Object, String> arg = new HashMap<>();
        if (collectionId != null && collectionId != 0) {
            arg.put(collectionId, "collection.collectionId");
        }
        return arg;
    }

    @Override
    public List<Map<Object, String>> toOrsPredicateMap(CategoryRepository categoryRepository) {
        List<Map<Object, String>> arg = new ArrayList<>();
        if (categoryIds != null && categoryIds.length != 0) {
            Map<Object, String> categoryMap = new HashMap<>();
            Arrays.stream(categoryIds).forEach(id -> categoryMap.put(id, "category.categoryId"));
            arg.add(categoryMap);
        }
        return arg;
    }

    public List<Map<Object, String>> toOrsPredicateMap() {
        return null;
    }
}