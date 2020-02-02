package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByCategoryId(Integer categoryId);

    List<Category> findAllByParentCategoryIdIsNull();

    List<Category> findAllByParentCategoryId(Integer parentId);
}
