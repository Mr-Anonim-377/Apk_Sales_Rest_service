package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Order;
import com.Sales.SalesWeb.model.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, UUID> {


}
