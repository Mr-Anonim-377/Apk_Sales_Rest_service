package com.Sales.SalesWeb.controller.requestDto.ProductResuest;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
public class ProductCategoryReqest extends ProductRequest {
    int page;
    BigDecimal minPrice;
    BigDecimal maxPrice;
    Integer[] collectionIds;
    String sort;  // Order By *,*,* Asc/Desc
    Integer categoryId;

    public Map<Object, String> toAndsPredicateMap() {
        Map<Object, String> arg = new HashMap<>();
        if (categoryId != null && categoryId != 0) {
            arg.put(categoryId, "category.categoryId");
        }
        return arg;
    }

    public List<Map<Object, String>> toOrsPredicateMap() {
        List<Map<Object, String>> arg = new ArrayList<>();
        if (collectionIds != null && collectionIds.length != 0) {
            Map<Object, String> collectionMap = new HashMap<>();
            Arrays.stream(collectionIds).forEach(id -> collectionMap.put(id, "collection.collectionId"));
            arg.add(collectionMap);
        }
        return arg;
    }
}
