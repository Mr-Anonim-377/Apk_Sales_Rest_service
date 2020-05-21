package com.Sales.SalesWeb.service.utils;

import com.Sales.SalesWeb.model.*;
import com.Sales.SalesWeb.model.DTO.*;

import java.util.ArrayList;
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

    public static SimularProductDto toSimilarProduct(SimilarProduct similarProduct) {
        Product similarsProduct = similarProduct.getSimilarsProduct();
        return new SimularProductDto(similarsProduct.getProductId(), similarsProduct.getNameProduct(),
                similarsProduct.getPrice(), similarsProduct.getMainImage());
    }

    public static ImagesProductDto toImagesProduct(ImagesProduct imagesProduct) {
        return new ImagesProductDto(imagesProduct.getImagesProduct(),
                imagesProduct.getImage());

    }

    public static CollectionDto toCollectionDto(Collection collection) {
        List<Product> collectionProducts = collection.getProducts();
        return new CollectionDto(collection.getCollectionId(),
                collection.getCollectionName(),
                collection.getCollectionDescription(),
                collection.getImage(),
                collectionProducts == null ? null : collectionProducts
                        .stream()
                        .map(Product::getProductId)
                        .collect(Collectors.toList()));
    }

    public static ProductReviewDto toProductReviewDto(ProductReview productReview) {
        return new ProductReviewDto(productReview.getProductReviewsId(), toReviewDto(productReview.getReview()),
                productReview.getProduct().getProductId());
    }

    public static ReviewDto toReviewDto(Review review) {
        return new ReviewDto(review.getReviewId(), review.getReviewTitle(), toUserDto(review.getUser()),
                review.getReviewMark(), review.getReviewDescription(), review.getReviewType());
    }

    public static UserDto toUserDto(User user) {
        Person person = user.getPerson();
        return new UserDto(person.getFirstName(), person.getLastName(), user.getImage());
    }

    public static OrderProductDto toOrderProductDto(OrderProduct orderProduct) {
        return new OrderProductDto(toProductDto(orderProduct.getProduct()), orderProduct.getCount());
    }

    public static OrderDeliveryDto toOrderDeliveryDto(OrderDelivery orderDelivery) {
        return new OrderDeliveryDto(orderDelivery.getAddress());
    }

    public static OrderDto toOrderDto(Order order) {
        List<OrderProduct> orderProducts = order.getOrderProducts();
        return new OrderDto(order.getIsPayment(),
                order.getPaymentType(),
                orderProducts == null || orderProducts.size() == 0 ? new ArrayList<>()
                        : orderProducts.stream().map(Mapper::toOrderProductDto).collect(Collectors.toList()),
                toOrderDeliveryDto(order.getOrderDelivery()),
                order.getOrderStatus()
        );
    }

    public static ProductDto toProductDto(Product product) {
        Collection collection = product.getCollection();
        Category category = product.getCategory();
        List<ImagesProduct> images = product.getImages();
        List<SimilarProduct> similarProducts = product.getSimilarProducts();
        List<ProductReview> productReviews = product.getProductReviews();
        return new ProductDto(product.getProductId(),
                product.getNameProduct(),
                category == null ? null : toCategoryDto(category),
                product.getPrice(),
                product.getMainImage(),
                images == null || images.size() == 0 ? new ArrayList<>()
                        : images.stream().map(Mapper::toImagesProduct).collect(Collectors.toList()),
                similarProducts == null || similarProducts.size() == 0
                        ? new ArrayList<>()
                        : similarProducts.stream().map(Mapper::toSimilarProduct)
                        .collect(Collectors.toList()),
                collection == null ? null : toCollectionDto(collection),
                product.getProperties(),
                product.getProductDescription(),
                product.getAverageMark() == null ? null : product.getAverageMark(),
                productReviews == null ? new ArrayList<>() : productReviews.stream().map(Mapper::toProductReviewDto)
                        .collect(Collectors.toList()));
    }
}
