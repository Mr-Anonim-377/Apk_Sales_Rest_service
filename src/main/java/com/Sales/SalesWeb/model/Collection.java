package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "collections")
@Getter
@Setter
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collectionId;

    private String collectionName;

    private String collectionDescription;

    @OneToOne()
    @JoinColumn (name="image_id")
    private Image image;

    @OneToMany(mappedBy = "collection")
    private List<Product> products = new ArrayList<>();
}
