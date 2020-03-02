package com.Sales.SalesWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {

    @Id
    private Integer saleId;

    private String saleName;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

    private BigDecimal discount;
}
