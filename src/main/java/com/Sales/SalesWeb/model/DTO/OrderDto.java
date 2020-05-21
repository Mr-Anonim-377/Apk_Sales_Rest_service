package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import com.Sales.SalesWeb.model.dbEnums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@ToString
public class OrderDto {
    private Boolean isPayment;

    private PaymentType paymentType;

    private List<OrderProductDto> orderProducts;

    private OrderDeliveryDto orderDelivery;

    private OrderStatus orderStatus;

    public OrderDto(Boolean isPayment, PaymentType paymentType, List<OrderProductDto> orderProducts, OrderDeliveryDto orderDelivery, OrderStatus orderStatus) {
        this.isPayment = isPayment;
        this.paymentType = paymentType;
        this.orderProducts = orderProducts;
        this.orderDelivery = orderDelivery;
        this.orderStatus = orderStatus;
    }

}
