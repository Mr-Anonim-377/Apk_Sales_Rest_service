package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "collections")
@Data
public class Collection {

    @Id
    private Integer collectionId;

    private String collectionName;

    private String collectionDescription;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

}
