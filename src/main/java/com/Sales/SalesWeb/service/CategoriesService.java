package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Category;
import com.Sales.SalesWeb.model.POJO.CategoriesNav;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryNav;
import com.Sales.SalesWeb.model.POJO.Navigation;
import com.Sales.SalesWeb.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        navigation.setFavoriteCategories(favoriteCategoriesService.getCountFavoriteCategories(5).stream()
                .map(i -> new FavoriteCategoryNav(categoryRepository
                        .findByCategoryId(i.getCategoryId()).getCategoryName(), i))
                .collect(Collectors.toList()));
        navigation.setCategoriesNavigation(getCategoriesNav());
        return navigation;
    }

    private List<CategoriesNav> getCategoriesNav() {
        List<Category> categoriesNavs = categoryRepository.findAllByParentCategoryIdIsNull();
        return categoriesNavs.stream()
                .map(i -> new CategoriesNav(i.getCategoryName(), i, getChildCategoriesNav(i.getCategoryId())))
                .collect(Collectors.toList());
    }

    private List<CategoriesNav> getChildCategoriesNav(Integer categoryId) {
        List<Category> allByParentCategoryId = categoryRepository.findAllByParentCategoryId(categoryId);
        if (!allByParentCategoryId.isEmpty()) {
            return allByParentCategoryId.stream()
                    .map(i -> new CategoriesNav(i.getCategoryName(), i, getChildCategoriesNav(i.getCategoryId())))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


}
