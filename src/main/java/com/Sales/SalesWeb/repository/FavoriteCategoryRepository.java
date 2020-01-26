package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.FavoriteCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;
@Repository
public interface FavoriteCategoryRepository extends JpaRepository<FavoriteCategory, UUID> {

    Page<FavoriteCategory> findAll(Pageable pageable);

    ArrayList<FavoriteCategory> findAll();

    FavoriteCategory findByFavoriteCategoryId(UUID favoriteCategoryId);
}

