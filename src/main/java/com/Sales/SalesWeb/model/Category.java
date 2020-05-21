package com.Sales.SalesWeb.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    //    private Integer parentCategoryId;

    @ManyToOne()
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> childCategory = new ArrayList<>();

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> categoryProducts = new ArrayList<>();
}
