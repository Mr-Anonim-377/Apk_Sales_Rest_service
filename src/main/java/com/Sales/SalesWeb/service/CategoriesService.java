package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.model.Category;
import com.Sales.SalesWeb.model.Collection;
import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.DTO.CollectionDto;
import com.Sales.SalesWeb.model.POJO.Navigation;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    final FavoriteCategoriesService favoriteCategoriesService;
    final CategoryRepository categoryRepository;

    public CategoriesService(FavoriteCategoriesService favoriteCategoriesService, CategoryRepository categoryRepository) {
        this.favoriteCategoriesService = favoriteCategoriesService;
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCollect() {
        List<CategoryDto> collections;
        try {
            List<Category> all = categoryRepository.findAll();
            collections = all.isEmpty()?null:all.stream().map(Mapper::toCategoryDto)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;
    }

    public Navigation getAllNavigationCategories() {
        Navigation navigation = new Navigation();

        navigation.setFavoriteCategories(favoriteCategoriesService.getCountFavoriteCategories(5));
        navigation.setCategoriesNavigation(categoryRepository.findAll()
                .stream()
                .map(Mapper::toCategoryDto)
                .filter(categoryDto -> categoryDto.getParentCategoryId() == null)
                .collect(Collectors.toList()));
        return navigation;
    }

    public List<Map<Integer,String>> getCollectionsByProductOfCategory(int categoryId){
        List<Map<Integer,String>> collections;
        try {
            collections = categoryRepository.getAllProductCollections(categoryId);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return collections;

    }
}
