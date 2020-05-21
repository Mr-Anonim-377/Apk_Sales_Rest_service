package com.Sales.SalesWeb.model.dbEnums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReviewType implements PgEnum {
    ORDER("ORDER"),
    SITE("SITE"),
    PRODUCT("PRODUCT");
    private final String sqlValue;
}
