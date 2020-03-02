package com.Sales.SalesWeb.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    private Integer categoryId;

    //    private Integer parentCategoryId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> childCategory;

    private String categoryName;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> categoryProducts;

}
