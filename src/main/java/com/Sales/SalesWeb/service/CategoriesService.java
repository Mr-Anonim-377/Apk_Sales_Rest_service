package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.POJO.Navigation;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoriesService {

    final FavoriteCategoriesService favoriteCategoriesService;
    final CategoryRepository categoryRepository;

    public CategoriesService(FavoriteCategoriesService favoriteCategoriesService, CategoryRepository categoryRepository) {
        this.favoriteCategoriesService = favoriteCategoriesService;
        this.categoryRepository = categoryRepository;
    }

    public Navigation getAllNavigationCategories() {
        Navigation navigation = new Navigation();

        navigation.setFavoriteCategories(favoriteCategoriesService.getCountFavoriteCategories(5));
        navigation.setCategoriesNavigation(categoryRepository.findAll()
                .stream()
                .map(Mapper::toCategoryDto)
                .collect(Collectors.toList()));
        return navigation;
    }
}
