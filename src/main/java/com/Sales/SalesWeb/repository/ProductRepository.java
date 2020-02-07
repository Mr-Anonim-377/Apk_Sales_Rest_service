package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {

    Page<Product> findAllByProductCategoryId(Integer productCategoryId, Pageable pageable);

    Page<Product> findAllByProductCategoryIdAndPriceAfterAndPriceBefore(Integer productCategoryId, BigDecimal min, BigDecimal max, Pageable pageable);

    List<Product> findAll();

    Product findByProductId(UUID productId);

    Page<Product> findByNameProductContains(String search, Pageable pageable);

    Page<Product> findByNameProductOrPropertiesOrProductDescriptionContains(String nameProduct, String properties, String productDescription, Pageable pageable);

    Page<Product> findByPropertiesContains(String search, Pageable pageable);

    Page<Product> findByProductDescriptionContains(String search, Pageable pageable);
}
