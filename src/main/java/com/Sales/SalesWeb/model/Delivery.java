package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID deliveryId;

    private String deliveryArea;

    private BigDecimal priceDelivery;
}
