package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterOnProduct {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer collectionId;
    private final Map<String, Predicate<Product>> filters = new HashMap<String, Predicate<Product>>() {{
        put("collectionId", collectionId != null ? i -> i.getCollection().getCollectionId().equals(collectionId) : Objects::nonNull);
        put("price", maxPrice != null && minPrice != null ? i -> {
            BigDecimal price = i.getPrice();
            return price.compareTo(minPrice) >= 0 && price.compareTo(maxPrice) <= 0;
        } : Objects::nonNull);
    }};

    public FilterOnProduct(BigDecimal minPrice, BigDecimal maxPrice, Integer collectionId) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.collectionId = collectionId;
    }

    public List<Product> applyFilterOnProducts(List<Product> products) {
        for (Predicate<Product> predicate : filters.values()) {
            products = products.stream().filter(predicate).collect(Collectors.toList());
        }
        return products;
    }
}
