package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dataType.PgEnumUserType;
import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import com.Sales.SalesWeb.model.dbEnums.PaymentType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    private UUID orderId;

    private Boolean isPayment;

    @Type(type = PgEnumUserType.TYPE, parameters = @org.hibernate.annotations.Parameter(
            name = PgEnumUserType.ENUM_CLASS_NAME, value = "com.Sales.SalesWeb.model.dbEnums.PaymentType"))
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_delivery_id")
    private OrderDelivery orderDelivery;

    @Type(type = PgEnumUserType.TYPE, parameters = @org.hibernate.annotations.Parameter(
            name = PgEnumUserType.ENUM_CLASS_NAME, value = "com.Sales.SalesWeb.model.dbEnums.OrderStatus"))
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String email;

    private String cod;

    private String phone;

    private String firstName;

    private String lastName;

}
