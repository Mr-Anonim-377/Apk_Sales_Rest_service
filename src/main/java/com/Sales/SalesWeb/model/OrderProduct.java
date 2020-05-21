package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders_products")
@Getter
@Setter
public class OrderProduct {

    @Id
    private UUID orderProductId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer count;
}
