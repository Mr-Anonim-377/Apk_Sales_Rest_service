package com.Sales.SalesWeb.model.response.entity;

import lombok.Data;

@Data
public class SimpleDbEntity<ID, V> {
    ID entityId;
    V attributeValue;
    String attributeType = null;
}
