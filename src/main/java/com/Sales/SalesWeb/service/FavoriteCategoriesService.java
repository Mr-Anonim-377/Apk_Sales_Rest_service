package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toFavoriteCategoryDto;

@Service
public class FavoriteCategoriesService extends AbstractService {
    private final FavoriteCategoryRepository favoriteCategoriesRepository;

    public FavoriteCategoriesService(FavoriteCategoryRepository favoriteCategoriesRepository) {
        this.favoriteCategoriesRepository = favoriteCategoriesRepository;
    }

    public FavoriteCategoryDto getfavoriteCategory(UUID id) {
        CheckedErrorFunction<UUID, FavoriteCategoryDto> functionSql = uuid -> {
            FavoriteCategory favoriteCategory = favoriteCategoriesRepository.findByFavoriteCategoryId(id);
            return favoriteCategory == null ? null : toFavoriteCategoryDto(favoriteCategory);
        };
        return  applyHibernateQuery(id,functionSql);
    }

    public List<FavoriteCategoryDto> getAllFavoriteCategories() {
        Callable<List<FavoriteCategoryDto>> functionSql = () ->
                favoriteCategoriesRepository.findAll(Sort.by("popularValue").descending())
                        .stream()
                        .map(Mapper::toFavoriteCategoryDto)
                        .collect(Collectors.toList());
        return applyHibernateQuery(functionSql);
    }

    public List<FavoriteCategoryDto> getCountFavoriteCategories(Integer count) {
        CheckedErrorFunction<Integer, List<FavoriteCategoryDto>> functionSql = (countValue) ->
                favoriteCategoriesRepository.findAll(PageRequest
                        .of(0, count, Sort.by("popularValue").descending())).getContent().stream()
                        .map(Mapper::toFavoriteCategoryDto)
                        .collect(Collectors.toList());
        return applyHibernateQuery(count, functionSql);
    }
}