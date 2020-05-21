package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sales_product")
@Getter
@Setter
public class SalesProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID saleProductId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private Sale sale;


    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}