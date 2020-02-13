package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "sales_product")
@Data
public class SalesProduct {

    @Id
    private UUID saleProductId;

    private Integer saleId;

    private UUID productId;
}