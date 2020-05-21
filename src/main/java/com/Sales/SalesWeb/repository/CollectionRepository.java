package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, UUID> {

    Collection findByCollectionId(Integer categoryId);

    List<Collection> findAll();

    @Query(value = "select DISTINCT c.collection_id,c.collection_name " +
            "from products as p " +
            "join collections as c on p.collection_id = c.collection_id " +
            "where p.category_id = :id", nativeQuery = true)
    List<Map<Integer,String>> getAllProductCollections(@Param("id") int id);
}
