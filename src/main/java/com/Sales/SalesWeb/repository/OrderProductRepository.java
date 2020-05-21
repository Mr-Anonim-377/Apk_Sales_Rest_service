package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {


}
