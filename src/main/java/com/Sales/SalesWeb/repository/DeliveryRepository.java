package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Delivery;
import com.Sales.SalesWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {


}
