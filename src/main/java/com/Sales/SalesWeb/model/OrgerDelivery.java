package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "orders_delivery")
@Getter
@Setter
public class OrgerDelivery {

    @Id
    private UUID orderDeliveryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_delivery_status")
    private OrderStatus orderDeliveryStatus;

    private String address;

    private Timestamp deliveryDate;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
