package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@Getter
@Setter
public class Delivery {

    @Id
    private UUID deliveryId;

    private String deliveryArea;

    private BigDecimal priceDelivery;
}
