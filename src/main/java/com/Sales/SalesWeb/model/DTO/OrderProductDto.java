package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Order;
import com.Sales.SalesWeb.model.OrderDelivery;
import com.Sales.SalesWeb.model.OrderProduct;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.model.dbEnums.OrderStatus;
import com.Sales.SalesWeb.model.dbEnums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
//@ToString
public class OrderProductDto {

    private ProductDto product;

    private Integer count;

    public OrderProductDto(ProductDto product, Integer count) {
        this.product = product;
        this.count = count;
    }
}
