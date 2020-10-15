package com.Sales.SalesWeb.controller.requestDto.SerchRequest;

import com.Sales.SalesWeb.model.DTO.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SearchResultResponse {

    List<ProductDto> products;

    Integer pageCount;

    BigDecimal minPrice;

    BigDecimal maxPrice;

    public SearchResultResponse(List<ProductDto> products, Integer pageCount, BigDecimal minPrice,
                                BigDecimal maxPrice) {
        this.products = products;
        this.pageCount = pageCount;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

}