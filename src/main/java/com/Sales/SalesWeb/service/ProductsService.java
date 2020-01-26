package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.model.FavoriteCategoryProduct;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryProductsRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final ProductRepository productRepository;
    private final FavoriteCategoryRepository favoriteCategoriesRepository;
    private final FavoriteCategoryProductsRepository favoriteCategoryProductsRepository;
    private final CategoryRepository categoryRepository;

    public ProductsService(ProductRepository productRepository,
                           FavoriteCategoryRepository favoriteCategoriesRepository,
                           FavoriteCategoryProductsRepository favoriteCategoryProductsRepository,
                           CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.favoriteCategoriesRepository = favoriteCategoriesRepository;
        this.favoriteCategoryProductsRepository = favoriteCategoryProductsRepository;
        this.categoryRepository = categoryRepository;
    }


    public Product getProduct(UUID id) {
        Product product;
        try {
            product = productRepository.findByProductId(id);
            ;
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return product;
    }

    public Product createProduct(Product product) {
        try {
            product = productRepository.save(product);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return product;

    }

    public boolean deleteProduct(Product product) {
        try {
            productRepository.delete(product);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productRepository.findById(product.getProductId()).isPresent();
    }

    public Map<String, Product> updateProduct(Product productFromDb, Product productFromReqest) {
        Map<String, Product> responseMap = new HashMap<>();
        try {
            BeanUtils.copyProperties(productFromDb, productFromReqest, "productId");
            responseMap.put("updatedProduct", productFromReqest);
            responseMap.put("currentProduct", productFromDb);

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return responseMap;
    }

    private List<Product> getFavoriteProductList(List<FavoriteCategoryProduct> favoriteCategoryProductList) {
        List<Product> productList = new ArrayList<>();
        for (FavoriteCategoryProduct favoriteCategoryProduct : favoriteCategoryProductList) {
            productList.add(productRepository.findByProductId(favoriteCategoryProduct.getProductId()));
        }
        return productList;
    }

    public List<FavoriteCategoryProductsResponse> getFavoriteCategoriesFavoriteProdcuts(Integer count) {
        List<FavoriteCategoryProductsResponse> responses;
        try {
            List<FavoriteCategory> favoriteCategories = favoriteCategoriesRepository
                    .findAll(PageRequest.of(0, count, Sort.by("popularValue").descending())).getContent();

            responses = favoriteCategories.stream()
                    .map(i -> new FavoriteCategoryProductsResponse(
                            categoryRepository.findByCategoryId(i.getCategoryId()).getCategoryName(),
                            i.getPopularValue(),
                            getFavoriteProductList(favoriteCategoryProductsRepository
                                    .findByFavoriteCategoryId(i.getFavoriteCategoryId()))))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return responses;
    }
}
