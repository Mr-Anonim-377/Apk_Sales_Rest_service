package com.Sales.SalesWeb.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "images_product")
@Getter
@Setter
public class ImagesProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID imagesProduct;

    @OneToOne()
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
