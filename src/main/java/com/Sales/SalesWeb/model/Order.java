package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import com.Sales.SalesWeb.model.dbEnums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    private UUID orderId;

    private Boolean isPayment;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_delivery_id")
    private OrgerDelivery orderDelivery;

//    private UUID orderDeliveryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

//    private UUID userId;

}
