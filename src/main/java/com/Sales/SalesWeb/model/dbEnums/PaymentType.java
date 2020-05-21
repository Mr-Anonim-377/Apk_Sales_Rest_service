package com.Sales.SalesWeb.model.dbEnums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType implements PgEnum {
    cash("cash"),
    non("non-cash");

    private final String sqlValue;
}
