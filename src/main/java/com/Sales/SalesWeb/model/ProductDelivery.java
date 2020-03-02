package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity()
@Table(name = "products_delivery")
@Getter
@Setter
public class ProductDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productDeliveryId;

    private BigDecimal saleDelivery;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
