package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.model.*;
import com.Sales.SalesWeb.model.DTO.*;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static FavoriteCategoryProductDto toFavoriteCategoryProductDto(FavoriteCategoryProduct favoriteCategoryProduct) {
        return new FavoriteCategoryProductDto(favoriteCategoryProduct.getFavoriteCategoryProductId(),
                toProductDto(favoriteCategoryProduct.getProduct()),
                toFavoriteCategoryDto(favoriteCategoryProduct.getFavoriteCategory()));
    }

    public static CategoryDto toCategoryDto(Category category) {
        Category parentCategory = category.getParentCategory();
        List<Product> categoryProducts = category.getCategoryProducts();
        return new CategoryDto(category.getCategoryId(),
                parentCategory == null ? null : parentCategory.getCategoryId(),
                category.getChildCategory().stream().map(Mapper::toCategoryDto).collect(Collectors.toList()),
                categoryProducts.isEmpty() ? null : categoryProducts
                        .stream()
                        .map(Product::getProductId)
                        .collect(Collectors.toList()),
                category.getCategoryName());
    }

    public static FavoriteCategoryDto toFavoriteCategoryDto(FavoriteCategory favoriteCategory) {
        return new FavoriteCategoryDto(favoriteCategory.getFavoriteCategoryId(),
                toCategoryDto(favoriteCategory.getCategory()), favoriteCategory.getPopularValue());

    }

    public static CollectionDto toCollectionDto(Collection collection) {
        List<Product> collectionProducts = collection.getCollectionProducts();
        return new CollectionDto(collection.getCollectionId(),
                collection.getCollectionName(),
                collection.getCollectionDescription(),
                collection.getImage(),
                collectionProducts == null ? null : collectionProducts
                        .stream()
                        .map(Mapper::toProductDto)
                        .collect(Collectors.toList()));
    }

    public static ProductDto toProductDto(Product product) {
        Collection collection = product.getCollection();
        Category category = product.getCategory();
        return new ProductDto(product.getProductId(),
                product.getNameProduct(),
                category == null ? null : toCategoryDto(category),
                product.getPrice(),
                product.getImage(),
                collection == null ? null : collection.getCollectionId(),
                product.getProperties(),
                product.getProductDescription());
    }
}
