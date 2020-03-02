package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Baner;
import com.Sales.SalesWeb.model.dbEnums.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BanersRepository extends JpaRepository<Baner, UUID> {

    List<Baner> findAll();

    List<Baner> findAllByBanerUsesStatus(Boolean banerStatus);

    Baner findByBanerId(Integer banerId);

    List<Baner> findAllByPageAndBanerUsesStatus(Page page, Boolean banerStatus);

}
