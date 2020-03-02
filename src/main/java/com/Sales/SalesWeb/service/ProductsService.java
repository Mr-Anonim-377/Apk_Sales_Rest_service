package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.model.FavoriteCategoryProduct;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryProductsRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.specification.AbstractSpecFacory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.service.utils.Mapper.toFavoriteCategoryDto;
import static com.Sales.SalesWeb.service.utils.Mapper.toProductDto;
import static com.Sales.SalesWeb.service.utils.SqlAssert.isEmpty;
import static com.Sales.SalesWeb.service.utils.SqlAssert.listAssert;

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

    public List<Object> getProductWithCollectionId(Map<String, List<BigDecimal>> betwenArg, int page, Map<String, Object> map) {
        AbstractSpecFacory abstractSpecFacory = new AbstractSpecFacory() {
            @Override
            protected <T> Predicate createBetwenPredicate(CriteriaBuilder criteriaBuilder, Root<Object> root,
                                                          List<T> betwenArg, String alias) {
                List<BigDecimal> currentArg = betwenArg.stream().map(element -> (BigDecimal) element)
                        .collect(Collectors.toList());
                return criteriaBuilder.between(root.get(alias), currentArg.get(0), currentArg.get(1));
            }
        };
        Pageable pageable = PageRequest.of(page, 4);
        Specification<Object> specification = abstractSpecFacory.getSpecification(betwenArg, map);
        List<Object> product;
        try {
            product = productRepository.findAll(specification, pageable).getContent();

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return product;
    }


    public ProductDto getProduct(UUID id) {
        ProductDto productDto;
        try {
            Product product = productRepository.findByProductId(id);
            productDto = product == null ? null : toProductDto(product);

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productDto;
    }

    public boolean createProduct(Product product) {
        try {
            productRepository.save(product);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productRepository.findById(product.getProductId()).isPresent();
    }

    public boolean deleteProduct(Product product) {
        try {
            productRepository.delete(product);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return productRepository.findById(product.getProductId()).isPresent();
    }

    public Map<String, ProductDto> updateProduct(Product productFromDb, Product productFromReqest) {
        Map<String, ProductDto> responseMap = new HashMap<>();
        try {
            BeanUtils.copyProperties(productFromDb, productFromReqest, "productId");
            responseMap.put("updatedProduct", toProductDto(productFromReqest));
            responseMap.put("currentProduct", toProductDto(productFromDb));

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return responseMap;
    }

    private List<ProductDto> getFavoriteProductList(List<FavoriteCategoryProduct> favoriteCategoryProductList) {
        listAssert(favoriteCategoryProductList,isEmpty());
        return favoriteCategoryProductList.stream()
                .map(i -> toProductDto(i.getProduct())).collect(Collectors.toList());
    }

    public List<FavoriteCategoryProductsResponse> getFavoriteCategoriesFavoriteProdcuts(Integer count) {
        List<FavoriteCategoryProductsResponse> responses = null;
        try {
            Page<FavoriteCategory> pageFavoriteCategories = favoriteCategoriesRepository
                    .findAll(PageRequest.of(0, count, Sort.by("popularValue").descending()));
            if (pageFavoriteCategories.isEmpty()) {
                throw new NoSuchObjects();
            }
            List<FavoriteCategory> favoriteCategories = pageFavoriteCategories.getContent();
            responses = favoriteCategories.stream().map(i -> new FavoriteCategoryProductsResponse(
                    toFavoriteCategoryDto(i),
                    getFavoriteProductList(favoriteCategoryProductsRepository
                            .findByFavoriteCategory_FavoriteCategoryId(i.getFavoriteCategoryId()))))
                    .collect(Collectors.toList());

        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return responses;
    }
}
