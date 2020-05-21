package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.ChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, UUID> {


}
