package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {

    List<Product> findAll();

    Product findByProductId(UUID productId);


    Page<Product> findByNameProductContains(String search, Pageable pageable);

//    @Query(
//            value = "SELECT * FROM products WHERE name_product  LIKE CONCAT('%',:search,'%')",
//            countQuery = "SELECT * FROM products WHERE name_product  LIKE CONCAT('%',:search,'%')",
//            nativeQuery = true)
//    ArrayList<Product> searchOnProductName(@Param("search")String search, Pageable pageable);
}
