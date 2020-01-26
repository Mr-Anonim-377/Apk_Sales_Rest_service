package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FavoriteCategoriesService {
    private final FavoriteCategoryRepository favoriteCategoriesRepository;

    public FavoriteCategoriesService(FavoriteCategoryRepository favoriteCategoriesRepository) {
        this.favoriteCategoriesRepository = favoriteCategoriesRepository;
    }

    public FavoriteCategory getfavoriteCategory(UUID id) {
        FavoriteCategory favoriteCategory;
        try {
            favoriteCategory = favoriteCategoriesRepository.findByFavoriteCategoryId(id);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategory;
    }

    public List<FavoriteCategory> getAllFavoriteCategories() {
        List<FavoriteCategory> favoriteCategories;
        try {
            favoriteCategories = favoriteCategoriesRepository.findAll(Sort.by("popularValue").descending());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategories;
    }

    public List<FavoriteCategory> getCountFavoriteCategories(Integer count) {
        Page<FavoriteCategory> favoriteCategories;
        try {
            favoriteCategories = favoriteCategoriesRepository.findAll(PageRequest
                    .of(0, count, Sort.by("popularValue").descending()));
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategories.getContent();
    }

}
