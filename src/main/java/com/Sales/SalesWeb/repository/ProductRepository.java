package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID>, JpaSpecificationExecutor<Product> {

    Product findFirstByCategory_CategoryIdOrderByPriceDesc(Integer categoryId);

    Product findFirstByCategory_CategoryIdOrderByPriceAsc(Integer categoryId);

    Product findFirstByCollection_CollectionIdOrderByPriceDesc(Integer collectionId);

    Product findFirstByNameProductContainingIgnoreCaseOrPropertiesContainingIgnoreCaseOrProductDescriptionContainingIgnoreCaseOrderByPriceDesc(String nameProduct,
                                                                                                           String properties, String productDescription);

    Product findFirstByCollection_CollectionIdOrderByPriceAsc(Integer collectionId);

    Product findFirstByNameProductContainingIgnoreCaseOrPropertiesContainingIgnoreCaseOrProductDescriptionContainingIgnoreCaseOrderByPriceAsc(String nameProduct,
                                                                                                          String properties, String productDescription);

    Product findByProductId(UUID productId);

}
