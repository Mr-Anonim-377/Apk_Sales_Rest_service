package com.Sales.SalesWeb.controller.requestDto.SerchRequest;

import com.Sales.SalesWeb.controller.enums.SearchType;
import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductRequest;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
public class SearchResultRequest extends ProductRequest {

    private String searchString;
//TODO Будующий функционал поиска по разным атрибутам
    private SearchType searchType;

    private int page;

    private String sort;

    private Integer[] collectionIds;

    private Integer[] categoryIds;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    public Map<Object, String> toAndsPredicateMap() {
        return new HashMap<>();
    }

    @Override
    public List<Map<Object, String>> toOrsPredicateMap(CategoryRepository categoryRepository) {
        return null;
    }

    public List<Map<Object, String>> toOrsPredicateMap() {
        List<Map<Object, String>> arg = new ArrayList<>();
        if (categoryIds != null && categoryIds.length != 0) {
            Map<Object, String> categoryMap = new HashMap<>();
            Arrays.stream(categoryIds).forEach(id -> categoryMap.put(id, "category.categoryId"));
            arg.add(categoryMap);
        }
        if (collectionIds != null && collectionIds.length != 0) {
            Map<Object, String> collectionMap = new HashMap<>();
            Arrays.stream(collectionIds).forEach(id -> collectionMap.put(id, "collection.collectionId"));
            arg.add(collectionMap);
        }
        return arg;
    }

    public List<Map<Object, String>> toLikePredicateMap() {
        List<Map<Object, String>> arg = new ArrayList<>();
        Map<Object, String> predicateMap = new HashMap<>();
        if (searchString != null && searchString.length() != 0) {
            switch (searchType) {
                case ON_PRODUCT_NAME:
                    predicateMap.put(searchString, "nameProduct");
                    arg.add(predicateMap);
                    break;
                case ON_PRODUCT_PROPERTIES:
                    predicateMap.put(searchString, "properties");
                    arg.add(predicateMap);
                    break;
                case ON_PRODUCT_DESCRIPTION:
                    predicateMap.put(searchString, "productDescription");
                    arg.add(predicateMap);
                    break;
                case ALL:
                    arg.add(ImmutableMap.of(searchString, "nameProduct"));
                    arg.add(ImmutableMap.of(searchString, "properties"));
                    arg.add(ImmutableMap.of(searchString, "productDescription"));
                    break;
                default:
                    throw new ApiException("SearchType not mapping -_-",
                            "Enum SearchType not mapping",
                            ExceptionType.ArgumentValueMismatch);
            }
        }
        return arg;
    }
}