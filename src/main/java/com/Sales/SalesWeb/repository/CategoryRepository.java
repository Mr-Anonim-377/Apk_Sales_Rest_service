package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Category;
import com.Sales.SalesWeb.model.response.entity.SimpleDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryId(Integer categoryId);

    List<Category> findAllByChildCategoryIsNull();

    List<Category> findAllByParentCategory_CategoryId(Integer parentId);

    @Query(value = "select DISTINCT c.category_id,c.category_name " +
            "from products as p " +
            "join categories as c on p.category_id = c.category_id " +
            "where p.collection_id = :id", nativeQuery = true)
    List<SimpleDbEntity<Integer, String>> getCategoriesByCollectionOfProduct(@Param("id") int id);

}
