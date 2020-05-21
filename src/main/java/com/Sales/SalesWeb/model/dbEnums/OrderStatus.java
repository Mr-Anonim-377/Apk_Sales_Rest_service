package com.Sales.SalesWeb.model.dbEnums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus implements PgEnum {
    creating("creating"),
    moderation("moderation"),
    delivering("delivering"),
    successfully("successfully"),
    canceled_by_user("canceled_by_user"),
    canceled_by_sales("canceled_by_sales"),
    not_delivered("canceled_by_sales");

    private final String sqlValue;

}
