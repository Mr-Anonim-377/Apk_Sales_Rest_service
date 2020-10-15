package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Banner;
import com.Sales.SalesWeb.model.dbEnums.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BanersRepository extends JpaRepository<Banner, UUID> {

    List<Banner> findAll();

    List<Banner> findAllByBanerUsesStatus(Boolean bannerStatus);

    Banner findByBanerId(Integer banerId);

    List<Banner> findAllByPageAndBannerUsesStatus(Page page, Boolean banerStatus);

}
