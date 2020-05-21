package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductRequest;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.ProductsResponse;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.model.FavoriteCategoryProduct;
import com.Sales.SalesWeb.model.POJO.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryProductsRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.specification.ProductSpecFactory;
import com.Sales.SalesWeb.service.utils.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.config.ControllerConfig.PAGE_SIZE;
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

    public ProductsResponse getProductWithProductRequest(int page, ProductRequest body) {
        ProductSpecFactory<Product> productSpecFactory = new ProductSpecFactory();
        Pageable pageable = body.createSort() == null ? PageRequest.of(page, PAGE_SIZE)
                : PageRequest.of(page, PAGE_SIZE, body.createSort());
        Specification<Product> specification = productSpecFactory
                .getOrAndEqualsBetweenSpecification(body.toMapBetween(),
                        body.toAndsPredicateMap(), body.toOrsPredicateMap());
        List<ProductDto> productsContent;
        Page<Product> productsPage;
        try {
            productsPage = productRepository.findAll(specification, pageable);
            productsContent = productsPage.getContent()
                    .stream().map(Mapper::toProductDto).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        return new ProductsResponse(productsContent,productsPage.getTotalPages());
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
        listAssert(favoriteCategoryProductList, isEmpty());
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
