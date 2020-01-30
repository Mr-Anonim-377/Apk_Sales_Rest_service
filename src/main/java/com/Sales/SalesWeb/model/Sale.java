package com.Sales.SalesWeb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Data
public class Sale {

    @Id
    private Integer saleId;

    private String saleName;

    private UUID imageId;

    private BigDecimal discount;
}
