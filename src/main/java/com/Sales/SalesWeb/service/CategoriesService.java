package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.model.Category;
import com.Sales.SalesWeb.model.DTO.CategoryDto;
import com.Sales.SalesWeb.model.response.entity.ResponseNavigationEntity;
import com.Sales.SalesWeb.model.response.entity.SimpleDbEntity;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
public class CategoriesService extends AbstractCatalogsEntityService {

    final FavoriteCategoriesService favoriteCategoriesService;
    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;

    public CategoriesService(FavoriteCategoriesService favoriteCategoriesService,
                             CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.favoriteCategoriesService = favoriteCategoriesService;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<CategoryDto> getAllCollect() {
        Callable<List<CategoryDto>> functionSql = () -> {
            List<Category> all = categoryRepository.findAll();
            return all.isEmpty() ? null : all.stream().map(Mapper::toCategoryDto)
                    .collect(Collectors.toList());
        };
        return applyHibernateQuery(functionSql);
    }

    public ResponseNavigationEntity getAllNavigationCategories() {
        ResponseNavigationEntity responseNavigationEntity = new ResponseNavigationEntity();
        responseNavigationEntity.setFavoriteCategories(favoriteCategoriesService.getCountFavoriteCategories(5));
        Callable<List<CategoryDto>> callableCategoryDto = () -> categoryRepository.findAll()
                .stream()
                .map(Mapper::toCategoryDto)
                .filter(categoryDto -> categoryDto.getParentCategoryId() == null)
                .collect(Collectors.toList());
        responseNavigationEntity.setCategoriesNavigation(applyHibernateQuery(callableCategoryDto));
        return responseNavigationEntity;
    }

    public List<SimpleDbEntity<Integer, String>> getCategoriesByCollectionIdOfProduct(int collectionId) {
        CheckedErrorFunction<Integer, List<SimpleDbEntity<Integer, String>>> functionSql =
                categoryRepository::getCategoriesByCollectionOfProduct;
        return applyHibernateQuery(collectionId, functionSql);
    }

    @Override
    protected BigDecimal getPriceMin(Integer id) {
        CheckedErrorFunction<Integer, BigDecimal> functionSql = idValue -> {
            BigDecimal minProductPrice = productRepository.findFirstByCategory_CategoryIdOrderByPriceAsc(id).getPrice();
            return minProductPrice == null ? new BigDecimal(1) : minProductPrice;
        };
        return applyHibernateQuery(id, functionSql);
    }

    @Override
    protected BigDecimal getPriceMax(Integer id) {
        CheckedErrorFunction<Integer, BigDecimal> functionSql = idValue -> {
            BigDecimal minProductPrice = productRepository.findFirstByCategory_CategoryIdOrderByPriceDesc(id).getPrice();
            return minProductPrice == null ? new BigDecimal(999999) : minProductPrice;
        };
        return applyHibernateQuery(id, functionSql);
    }
}