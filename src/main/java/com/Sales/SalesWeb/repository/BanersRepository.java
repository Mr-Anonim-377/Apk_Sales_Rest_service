package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Baner;
import com.Sales.SalesWeb.model.enums.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BanersRepository extends JpaRepository<Baner, UUID> {

    List<Baner> findAll();

    List<Baner> findAllByBanerStatus(Boolean banerStatus);

    Baner findByBanerIdAndBanerStatus(Integer banerId, Boolean banerStatus);

    List<Baner> findAllByPageAndBanerStatus(Page page, Boolean banerStatus);

}
