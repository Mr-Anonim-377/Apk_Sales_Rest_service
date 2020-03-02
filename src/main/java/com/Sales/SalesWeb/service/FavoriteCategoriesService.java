package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toFavoriteCategoryDto;

@Service
public class FavoriteCategoriesService {
    private final FavoriteCategoryRepository favoriteCategoriesRepository;

    public FavoriteCategoriesService(FavoriteCategoryRepository favoriteCategoriesRepository) {
        this.favoriteCategoriesRepository = favoriteCategoriesRepository;
    }

    public FavoriteCategoryDto getfavoriteCategory(UUID id) {
        FavoriteCategoryDto favoriteCategoryDto;
        try {
            FavoriteCategory favoriteCategory = favoriteCategoriesRepository.findByFavoriteCategoryId(id);
            favoriteCategoryDto = favoriteCategory==null?null:toFavoriteCategoryDto(favoriteCategory);;
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategoryDto;
    }

    public List<FavoriteCategoryDto> getAllFavoriteCategories() {
        List<FavoriteCategoryDto> favoriteCategories;
        try {
            favoriteCategories = favoriteCategoriesRepository.findAll(Sort.by("popularValue").descending()).stream()
                    .map(Mapper::toFavoriteCategoryDto)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategories;
    }

    public List<FavoriteCategoryDto> getCountFavoriteCategories(Integer count) {
        List<FavoriteCategoryDto> favoriteCategories;
        try {
            favoriteCategories = favoriteCategoriesRepository.findAll(PageRequest
                    .of(0, count, Sort.by("popularValue").descending())).stream()
                    .map(Mapper::toFavoriteCategoryDto)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return favoriteCategories;
    }

}
