package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.NoSuchObjects;
import com.Sales.SalesWeb.controller.requestDto.ProductResuest.*;
import com.Sales.SalesWeb.model.DTO.ProductDto;
import com.Sales.SalesWeb.model.FavoriteCategory;
import com.Sales.SalesWeb.model.FavoriteCategoryProduct;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.response.entity.FavoriteCategoryProductsResponse;
import com.Sales.SalesWeb.repository.CategoryRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryProductsRepository;
import com.Sales.SalesWeb.repository.FavoriteCategoryRepository;
import com.Sales.SalesWeb.repository.ProductRepository;
import com.Sales.SalesWeb.service.specification.ProductSpecFactory;
import com.Sales.SalesWeb.service.utils.Mapper;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.Sales.SalesWeb.config.ControllerConfig.PAGE_SIZE;
import static com.Sales.SalesWeb.service.utils.Mapper.toFavoriteCategoryDto;
import static com.Sales.SalesWeb.service.utils.Mapper.toProductDto;

@Service
public class ProductsService extends AbstractService {
    private final ProductRepository productRepository;
    private final FavoriteCategoryRepository favoriteCategoriesRepository;
    private final FavoriteCategoryProductsRepository favoriteCategoryProductsRepository;
    private final CategoryRepository categoryRepository;
    private final CollectionService collectionService;

    public ProductsService(ProductRepository productRepository,
                           FavoriteCategoryRepository favoriteCategoriesRepository,
                           FavoriteCategoryProductsRepository favoriteCategoryProductsRepository,
                           CategoryRepository categoryRepository, CollectionService collectionService) {
        this.productRepository = productRepository;
        this.favoriteCategoriesRepository = favoriteCategoriesRepository;
        this.favoriteCategoryProductsRepository = favoriteCategoryProductsRepository;
        this.categoryRepository = categoryRepository;
        this.collectionService = collectionService;
    }

    public String getCategoryNameById(Integer id) {
        CheckedErrorFunction<Integer, String> sqlFunction = categoryId ->
                categoryRepository.getOne(categoryId).getCategoryName();
        return applyHibernateQuery(id, sqlFunction);
    }

    public String getCollectionNameById(Integer id) {
        CheckedErrorFunction<Integer, String> sqlFunction = collectionId ->
                collectionService.getCollect(collectionId).getCollectionName();
        return applyHibernateQuery(id, sqlFunction);
    }

    private <T extends ProductsResponse> T updateProductResponse(T response, int page, ProductRequest body) {
        ProductSpecFactory<Product> productSpecFactory = new ProductSpecFactory();
        Specification<Product> specification = productSpecFactory
                .getOrAndEqualsBetweenSpecification(body.toMapBetween(),
                        body.toAndsPredicateMap(), body.toOrsPredicateMap(categoryRepository));
        Sort sort = body.createSort();
        Pageable pageable = sort == null ? PageRequest.of(page, PAGE_SIZE, Sort.by("averageMark"))
                : PageRequest.of(page, PAGE_SIZE, sort);
        CheckedErrorFunction<Pageable, Page<Product>> sqlFunction = functionPageable ->
                productRepository.findAll(specification, functionPageable);
        Page<Product> productsPage = applyHibernateQuery(pageable, sqlFunction);
        List<ProductDto> productsContent = productsPage.getContent().stream()
                .map(Mapper::toProductDto).collect(Collectors.toList());
        response.setPageCount(productsPage.getTotalPages());
        response.setProducts(productsContent);
        return response;
    }

    public ProductsCategoryResponse getProductsWithProductRequest(int page, ProductCategoryRequest body) {
        return updateProductResponse(new ProductsCategoryResponse(), page, body);
    }

    public ProductsCollectionResponse getProductsWithProductRequest(int page, ProductCollectionRequest body) {
        return updateProductResponse(new ProductsCollectionResponse(), page, body);
    }

    public ProductDto getProduct(UUID id) {
        CheckedErrorFunction<UUID, ProductDto> sqlFunction = uuid -> {
            Product product = productRepository.findByProductId(id);
            return product == null ? null : toProductDto(product);
        };
        return applyHibernateQuery(id, sqlFunction);
    }

    public boolean createProduct(Product product) {
        CheckedErrorFunction<Product, Boolean> sqlFunction = savingProduct ->
                productRepository.findById(productRepository.save(savingProduct).getProductId()).isPresent();
        return applyHibernateQuery(product, sqlFunction);
    }

    public boolean deleteProduct(Product product) {
        CheckedErrorFunction<Product, Boolean> sqlFunction = deletingProduct -> {
            productRepository.delete(deletingProduct);
            return !productRepository.findById(deletingProduct.getProductId()).isPresent();
        };
        return applyHibernateQuery(product, sqlFunction);
    }

    public Map<String, ProductDto> updateProduct(Product productFromDb, Product productFromRequest) {
        CheckedErrorFunction<Product, Map> sqlFunction = updatingProduct -> {
            BeanUtils.copyProperties(updatingProduct, productFromRequest, "productId");
            return ImmutableMap.of("updatedProduct", toProductDto(productFromRequest),
                    "currentProduct", toProductDto(updatingProduct));
        };
        return applyHibernateQuery(productFromDb, sqlFunction);
    }

    private List<ProductDto> getFavoriteProductList(List<FavoriteCategoryProduct> favoriteCategoryProductList) {
        listAssert(favoriteCategoryProductList, isEmpty());
        return favoriteCategoryProductList.stream()
                .map(i -> toProductDto(i.getProduct())).collect(Collectors.toList());
    }

    public List<FavoriteCategoryProductsResponse> getFavoriteCategoriesFavoriteProducts(Integer count) {
        CheckedErrorSupplier<List<FavoriteCategoryProductsResponse>> sqlFunction = () -> {
            Page<FavoriteCategory> pageFavoriteCategories = favoriteCategoriesRepository
                    .findAll(PageRequest.of(0, count, Sort.by("popularValue").descending()));
            Predicate<Page<FavoriteCategory>> pagePredicate = (page) -> page.isEmpty();
            objectAssert(new NoSuchObjects(), pagePredicate, pageFavoriteCategories);
            return pageFavoriteCategories.getContent().stream().map(i -> new FavoriteCategoryProductsResponse(
                    toFavoriteCategoryDto(i),
                    getFavoriteProductList(favoriteCategoryProductsRepository
                            .findByFavoriteCategory_FavoriteCategoryId(i.getFavoriteCategoryId()))))
                    .collect(Collectors.toList());
        };
        return applyHibernateQuery(sqlFunction);
    }
}