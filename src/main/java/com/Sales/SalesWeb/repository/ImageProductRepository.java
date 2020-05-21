package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.ImagesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImageProductRepository extends JpaRepository<ImagesProduct, UUID> {

    List<ImagesProduct> findAllByProduct_ProductId(UUID productId);
}
