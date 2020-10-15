package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity()
@Table(name = "images")
@Getter
@Setter

public class Image {

    @Id
    private UUID imageId;

    private String imagePatch;

}


