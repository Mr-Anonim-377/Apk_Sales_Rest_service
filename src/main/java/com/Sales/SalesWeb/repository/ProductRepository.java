package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID>, JpaSpecificationExecutor<Product> {

    Page<Product> findAllByCategory_CategoryId(Integer productCategoryId, Pageable pageable);

    Page<Product> findAllByCategory_CategoryIdAndPriceAfterAndPriceBefore(Integer productCategoryId, BigDecimal min, BigDecimal max, Pageable pageable);

    Product findFirstByCategory_CategoryIdOrderByPriceDesc(Integer categoryId);

    Product findFirstByCategory_CategoryIdOrderByPriceAsc(Integer categoryId);

    Product findFirstByCollection_CollectionIdOrderByPriceDesc(Integer collectionId);

    Product findFirstByCollection_CollectionIdOrderByPriceAsc(Integer collectionId);

    Product findByProductId(UUID productId);

    Page<Product> findByNameProductContains(String search, Pageable pageable);

    Page<Product> findByNameProductContainsOrPropertiesContainsOrProductDescriptionContains(String nameProduct, String properties, String productDescription, Pageable pageable);

    Page<Product> findByPropertiesContains(String search, Pageable pageable);

    Page<Product> findByProductDescriptionContains(String search, Pageable pageable);
}
