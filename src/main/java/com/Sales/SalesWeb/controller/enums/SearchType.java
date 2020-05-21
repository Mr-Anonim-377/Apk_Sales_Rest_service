package com.Sales.SalesWeb.controller.enums;

public enum SearchType {
    ALL("ALL"),
    ON_PRODUCT_NAME("NameProduct"),
    ON_PRODUCT_PROPERTIES("Properties"),
    ON_PRODUCT_DESCRIPTION("ProductDescription");
    private String searchType;

    SearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchType() {
        return searchType;
    }
}
