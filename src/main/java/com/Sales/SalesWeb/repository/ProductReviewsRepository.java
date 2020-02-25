package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.ProductReview;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductReviewsRepository extends CrudRepository<ProductReview, UUID>, JpaSpecificationExecutor<Object> {

}
