package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "collections")
@Getter
@Setter
public class Collection {

    @Id
    private Integer collectionId;

    private String collectionName;

    private String collectionDescription;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

    @OneToMany(mappedBy = "collection", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> collectionProducts;
}
