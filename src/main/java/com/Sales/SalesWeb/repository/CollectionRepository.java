package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, UUID> {

    Collection findByCollectionId(Integer categoryId);

    List<Collection> findAll();

}
