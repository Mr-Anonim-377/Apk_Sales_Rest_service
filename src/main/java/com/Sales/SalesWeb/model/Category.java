package com.Sales.SalesWeb.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "categories")
@Data
public class Category {

    @Id
    private Integer categoryId;

    private Integer parentCategoryId;

    private String categoryName;

}
